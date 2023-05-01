module com.burger_menu.burger_menu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.burger_menu.burger_menu to javafx.fxml;
    exports com.burger_menu.burger_menu;
}