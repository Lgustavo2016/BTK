package Extras;

import javax.mail.Session;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Email extends JFrame {

    public void enviarEmail(String emailLocatario, String nome) {
        final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
        final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bib.irmacharlita@gmail.com", "charlitairma");
            }
        });
        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bib.irmacharlita@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(emailLocatario);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Biblioteca Irmã Charlita");//Assunto
            message.setContent(emailsAtrasados(), "text/html");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "<html><h3>E-mail enviado com Sucesso!</h3></html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE, sucesso);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "<html><h3>Não foi possível enviar o E-mail!<br> Erro: " + e + "</h3></html>", "ERRO", JOptionPane.ERROR_MESSAGE, erro);
            throw new RuntimeException(e);
        }
    }

    private String realizarEmprestimo(String nome, String obra, String dataEmp, String dataDev) {

        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "	body{\n"
                + "	background-color: #99FFCC;\n"
                + "	}\n"
                + "\n"
                + "	h1{\n"
                + "	color: blue;\n"
                + "	text-align: center;\n"
                + "	}\n"
                + "        h2{\n"
                + "        color:black;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + " h3{\n"
                + "        color: red;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + "p {\n"
                + "    font-family: \"Times New Roman\";\n"
                + "    font-size: 20px;\n"
                + "    text-align:Center;\n"
                + "}\n"
                + "img {text-align:center; \n width:100%;\n height:auto;}"
                +"#imagem{text-align:center;  }"
                + "\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    \n"
                +"<div id=\"imagem\">"
                + "<img src=\"..\\Imagens\\logo.png\"> "
                +"</div>"
                + "	<h1><b>BTK</b></h1>\n"
                + "<h2><b>Sistema Bibliotecário</b></h2>\n"
                + "        <h2><i>Escola Estadual Irmã Charlita</i><h2>   \n"
                + "	<p>Você, " + nome + ", realizou o emprestimo do livro <i>" + obra + "</i>"
                + "        no dia " + dataEmp + ", com devolução prevista para " + dataDev + "</p>"
                + "        <h3><b>Não perca a data de devolução!!</b> \n"
                + "</h3>\n"
                + "</body>\n"
                + "</html>";
    }

    private String devolverEmprestimo(String nome, String obra, String dataEmp) {
       return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "	body{\n"
                + "	background-color: #99FFCC;\n"
                + "	}\n"
                + "\n"
                + "	h1{\n"
                + "	color: blue;\n"
                + "	text-align: center;\n"
                + "	}\n"
                + "        h2{\n"
                + "        color:black;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + " h3{\n"
                + "        color: red;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + "p {\n"
                + "    font-family: \"Times New Roman\";\n"
                + "    font-size: 20px;\n"
                + "    text-align:Center;\n"
                + "}\n"
                + "img {text-align:center; \n width:100%;\n height:auto;}"
                +"#imagem{text-align:center;  }"
                + "\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    \n"
                +"<div id=\"imagem\">"
                + "<img src=\"..\\Imagens\\logo.png\"> "
                +"</div>"
                + "	<h1><b>BTK</b></h1>\n"
                + "<h2><b>Sistema Bibliotecário</b></h2>\n"
                + "        <h2><i>Escola Estadual Irmã Charlita</i><h2>   \n"
                + "	<p>Parabéns!" + nome + ", você realizou a devolução do livro <i>" + obra + "</i>"
                + "        no dia " + dataEmp + " .</p>"
                + "     <p>Você já pode solicitar novos empréstimos na biblioteca.</p>"
                + "</h3>\n"
                + "</body>\n"
                + "</html>";
    }

    private String emailsAtrasados() {
      return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "	body{\n"
                + "	background-color: #99FFCC;\n"
                + "	}\n"
                + "\n"
                + "	h1{\n"
                + "	color: blue;\n"
                + "	text-align: center;\n"
                + "	}\n"
                + "        h2{\n"
                + "        color:black;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + " h3{\n"
                + "        color: red;\n"
                + "        text-align: center;  \n"
                + "        }  \n"
                + "p {\n"
                + "    font-family: \"Times New Roman\";\n"
                + "    font-size: 20px;\n"
                + "    text-align:Center;\n"
                + "}\n"
                + "img {text-align:center; \n width:100%;\n height:auto;}"
                +"#imagem{text-align:center;  }"
                + "\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    \n"
                +"<div id=\"imagem\">"
                + "<img src=\"..\\Imagens\\logo.png\"> "
                +"</div>"
                + "	<h1><b>BTK</b></h1>\n"
                + "<h2><b>Sistema Bibliotecário</b></h2>\n"
                + "        <h2><i>Escola Estadual Irmã Charlita</i><h2>   \n"
                + "	<p>Estamos decepcionados com você," /*+ nome  */ + ". Você não realizou a devolução do livro <i>"/*+ obra*/ + "</i>"
                + "        na data: " /*+ dataDev*/ + " .</p>"
                + "     <h3>Compareça a biblioteca e devolva o(s) livro(s) assim que possível</h3>"
                + "</h3>\n"
                + "</body>\n"
                + "</html>";
    }
}
