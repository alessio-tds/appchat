package umu.tds.apps;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class UserRepository {
    private static final UserRepository INSTANCE = new UserRepository();
    private ServicioPersistencia persistenceSystem = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
    private Gson gson = new Gson();

    private UserRepository() {}

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    public void saveUser(User user) {
        Entidad userEntity = new Entidad();
        userEntity.setNombre(user.getName());
        userEntity.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(
            new Propiedad("phoneNumber", user.getPhoneNumber()),
            new Propiedad("password", user.getPassword()),
            new Propiedad("dateOfBirth", (user.getDateOfBirth().isPresent()) ? user.getDateOfBirth().get().toString() : ""),
            new Propiedad("image", (user.getImage().isPresent()) ? user.getImage().get() : ""),
            new Propiedad("greeting", user.getGreeting()),
            new Propiedad("chats", gson.toJson(user.getChats())),
            new Propiedad("messages", gson.toJson(user.getMessages()))
        )));
        persistenceSystem.registrarEntidad(userEntity);
        user.setId(userEntity.getId());
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        ArrayList<Entidad> entities = persistenceSystem.recuperarEntidades();

        if (entities.isEmpty()) {
            return null;
        }

        Optional<Entidad> userEntityOpt = entities.stream()
            .filter(en -> en.getPropiedades().stream()
                .anyMatch(prop -> prop.getNombre().equals("phoneNumber") && prop.getValor().equals(phoneNumber))
            )
            .findFirst();
        
        if (!userEntityOpt.isPresent()) {
            return null;
        }

        Entidad userEntity = userEntityOpt.get();

        String name = userEntity.getNombre();
        String password = persistenceSystem.recuperarPropiedadEntidad(userEntity, "password");
        String greeting = persistenceSystem.recuperarPropiedadEntidad(userEntity, "greeting");

        String dateOfBirthStr = persistenceSystem.recuperarPropiedadEntidad(userEntity, "dateOfBirth");
        Optional<LocalDate> dateOfBirth = (dateOfBirthStr.isEmpty()) ? Optional.empty() : Optional.of(LocalDate.parse(dateOfBirthStr));

        String imageStr = persistenceSystem.recuperarPropiedadEntidad(userEntity, "image");
        Optional<String> image = (imageStr.isEmpty()) ? Optional.empty() : Optional.of(imageStr);

        Type chatListType = new TypeToken<ArrayList<Chat>>() {}.getType();
        ArrayList<Chat> chats = gson.fromJson(persistenceSystem.recuperarPropiedadEntidad(userEntity, "chats"), chatListType);

        Type messageListType = new TypeToken<ArrayList<Message>>() {}.getType();
        ArrayList<Message> messages = gson.fromJson(persistenceSystem.recuperarPropiedadEntidad(userEntity, "messages"), messageListType);

        User user = new User(name, phoneNumber, password, dateOfBirth, image, greeting);
        user.setChats(chats);
        user.setMessages(messages);
        user.getContacts();
        user.getGroups();

        return user;
    }

    public void updateUser(User user) {
        // TODO
        return;
    }

    public void deleteUserByPhoneNumber(String phoneNumber) {
        Entidad userEntity = persistenceSystem.recuperarEntidad(Integer.parseInt(phoneNumber));
        persistenceSystem.borrarEntidad(userEntity);
    }
}
