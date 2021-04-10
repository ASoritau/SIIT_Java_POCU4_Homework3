package org.HomeWork3;

import org.HomeWork3.Phones.CommunicationsLogic.GenericTelephoneOperator;
import org.HomeWork3.Phones.CommunicationsLogic.Message;
import org.HomeWork3.Phones.Devices.I_Phone;
import org.HomeWork3.Phones.Devices.Manufacurers.Nokia.Nokia7plus;
import org.HomeWork3.Phones.PhysicalProperties.Color;

import java.util.List;

/**
 * HomeWork 3
 *
 */
public class App_HW3
{
    public static void main( String[] args )
    {
        GenericTelephoneOperator defaultOperator = new GenericTelephoneOperator();

        I_Phone phone1 = new Nokia7plus(defaultOperator);
        I_Phone phone2 = new Nokia7plus(Color.White, defaultOperator);

        phone1.sendMessage(phone2.getOwnNumber(), "Salut! Ajung in 5 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Ajung in 2 min.");
        phone1.sendMessage(phone2.getOwnNumber(), "Am ajuns.");
        phone1.sendMessage(142, "Message");

        phone1.callNumber(phone2.getOwnNumber());
        phone2.callNumber(phone1.getOwnNumber());
        phone2.addContact(phone1.getOwnNumber(), "Ion", "Ionescu");

        List<Message> conversation = phone1.getConversationWithNumber(phone2.getOwnNumber());
        for (Message message : conversation) {
            System.out.println(message.toString());
        }

        List<String> phone1CallLog = phone1.getCallLog();
        for (String call : phone1CallLog) {
            System.out.println(call);
        }

        List<String> phone2CallLog = phone2.getCallLog();
        for (String call : phone2CallLog) {
            System.out.println(call);
        }
    }
}
