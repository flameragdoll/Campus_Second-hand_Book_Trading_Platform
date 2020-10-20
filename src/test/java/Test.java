public class Test {
    public static void main(String[] args) {
        User a=new User("a");
        User b=new User("b");
        User c=new User("c");
        User d=new User("d");
        User e=new User("e");
        Group group1=new Group("计科");
        Group group2=new Group("软工");
        group1.Join(a);group1.Join(b);group1.Join(e);
        group2.Join(c);group2.Join(d);group2.Join(e);
        Book book1=new Book("《计科》","教授","武汉大学出版社", (float) 66.66,"九成新",a.getName());
        Book book2=new Book("《软工》","教授","武汉大学出版社", (float) 66.66,"九成新",c.getName());
        a.post(book1,group1);
        e.browse();
        c.post(book2,group2);
        b.browse();
    }
}
