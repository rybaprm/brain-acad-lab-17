package ua.zp.brainacad;

public class Store {
    private String name;
    private String url;
    private User[] users;
    private User authorizedUser;

    public Store(String name, String url, User[] users) {
        this.name = name;
        this.url = url;
        this.users = users;
    }

    public boolean login(String login, String password) {
        boolean authorized = false;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                authorizedUser = user;
                authorized = true;
            }
        }
        return authorized;
    }

    public void getCurrentUserRights() {
        switch (authorizedUser.getRole().name()) {
            case "director":
                System.out.println("Директор магазина, может управлять кадрами, и ценами");
                break;
            case "administrator":
                System.out.println("Администратор магазина, может добавлять товары и редактировать их описание");
                break;
            case "manager":
                System.out.println("Менеджер магазина, может общаться с клиентами");
                break;
            case "client":
                System.out.println("Клиент магазина, может покупать товары и пользоваться дисконтом");
                break;
            case "anonymous":
                System.out.println("Анонимный пользователь, может покупать товары и\\или авторизоваться");
                break;
        }
    }
    public void logout(){
        authorizedUser = null;
        System.out.println("Пользователь вышел из системы");
    }
}
