package pattern.structural.composite;

public class Test {

    public static void main(String[] args) {
        CatalogComponent linux = new Course("linux", 50);
        CatalogComponent windows = new Course("windows", 40);

        CatalogComponent java = new CourseCatalog("java catalog", 2);
        CatalogComponent java_design = new Course("java_design", 50);
        CatalogComponent java_algo = new Course("java_algo", 60);
        CatalogComponent spring = new Course("java_spring", 100);

        java.add(java_design);
        java.add(java_algo);
        java.add(spring);

        CatalogComponent coursedir = new CourseCatalog("main dir", 1);
        coursedir.add(java);
        coursedir.add(windows);
        coursedir.add(linux);

        coursedir.print();
    }

}
