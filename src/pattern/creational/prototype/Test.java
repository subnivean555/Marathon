package pattern.creational.prototype;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();

        mail.setContent("初始化模板");
        for (int i = 0; i < 10; i++){
            Mail temp = (Mail) mail.clone();
            temp.setName("xingming"+i);
            temp.setEmaillAdd("address"+i+"@qq.com");
            temp.setContent("nizhongjiangle");
            MailUtil.sendMail(temp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
