package Framework;

public class Email {
    private String Subject;
    private String Content;

    public Email(String subject, String content) {
        Subject = subject;
        Content = content;
    }

    public String getSubject() {
        return Subject;
    }

    public String getContent() {
        return Content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Subject='" + Subject + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
