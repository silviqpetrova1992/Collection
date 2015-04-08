package exceptionMessanger;


import java.util.Hashtable;

/**
 * Created by clouway on 4/6/15.
 */
public class ExceptionMessageManager {
 private  Hashtable<String, String> hashtable = new Hashtable<String, String>();
  private StringBuilder listOfMessages = new StringBuilder();

  /**
   * Adds values with their keys in hashtable
   * @param messageCode is the key
   * @param message is the value
   * @throws ProgramerException
   */
  public void registerErrorMessage(String messageCode, String message) throws ProgramerException {
    if (hashtable.containsKey(messageCode)) {
      throw new ProgramerException("This value already has it!");
    } else {
      hashtable.put(messageCode, message);
    }
  }

  /**
   * Adds the element in String
   * @param messageCode is the key which we compare the values
   * @throws ProgramerException
   */
  public void raiseError(String messageCode) throws ProgramerException {
    if (hashtable.containsKey(messageCode)) {
      listOfMessages = listOfMessages.append(messageCode);
      listOfMessages = listOfMessages.append("  ");
    } else {
      throw new ProgramerException("There is not value with this key!");
    }
  }

  /**
   * Prints the string
   * @return stringBuilder
   */
  public String getErrorMessages() {
    String list = listOfMessages.toString();
    return list;
  }
}
