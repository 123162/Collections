package odev3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Odev3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Contact> contactList = new ArrayList<>();

//soyadına göre sıralanmış kişileri boş bir  lastNameContactList isimli Arrayliste atmak için tanımladım.
//daha sonra collection.sort methodu  ile bunları sıralayıp oluşturuduğum boş diziye attım. ve bunları 
//contactArrayListOrderByLastName txt ime yazdım.
        List<Contact> lastNameContactList = new ArrayList<>();
        Collections.sort(contactList, new LastNameComparator());
        for (int i = 0; i < contactList.size(); i++) {
            lastNameContactList.add(contactList.get(i));
        }
        textYazma(lastNameContactList, "contactArrayListOrderByLastName.txt");
        //txt dosyamı okuduğum ve yazdığım methodları çağırdım.
        textOkuma(contactList);
        textYazma(contactList, "contactArrayList.txt");

        //**********************************************************************
        TreeSet<Contact> contactTree = new TreeSet<>();

        for (Contact cnt : contactList) {
            contactTree.add(cnt);
        }
        textYazma(contactTree, " contactTreeSet.txt");

        //**********************************************************************
        //soyadına göre sıralanmış kişileri boş bir  lastNameContactTree isimli Arrayliste atmak için tanımladım.
//daha sonra collection.sort methodu  ile bunları sıralayıp oluşturuduğum boş diziye attım. ve bunları 
//contactTreeSetOrderByLastName txt ime yazdım.
        Set<Contact> lastNameContactTree = new TreeSet<>();
        Collections.sort(contactList, new LastNameComparator());//treeSEt de yazma işleminde hata verdiği için bu hatayı alıyorum
        for (int i = 0; i < contactList.size(); i++) {
            lastNameContactTree.add(contactList.get(i));
        }
        textYazma(lastNameContactTree, "contactTreeSetOrderByLastName.txt");

        //***********************************************************************
        HashSet<Contact> contactHash = new HashSet();
        for (Contact cnt : contactList) {
            contactHash.add(cnt);
        }
        textYazma(contactHash, "contactHashSet.txt");
        //************************************************************
        HashMap<String, Contact> contactMap = new HashMap<>();
        for (Contact cnt : contactList) {
            contactMap.put(satirList[0], contactList);
        }
        textYazma(contactMap, "contactHashMap.txt");

    }

    public static void textOkuma(ArrayList<Contact> contactList) throws FileNotFoundException, IOException {

        FileReader rd = new FileReader("contacts.txt");
        BufferedReader br = new BufferedReader(rd);
        String satir = "";
        String[] satirList;
        while ((satir = br.readLine()) != null) {
            satirList = satir.split(" ");
            Contact temp = new Contact();
            temp.setPhoneNumber(satirList[0]);
            temp.setFirstName(satirList[1]);
            temp.setLastName(satirList[2]);
            temp.setSocialSecurityNumber(satirList[3]);
            contactList.add(temp);

        }
        br.close();
        rd.close();
    }

    public static void textYazma(ArrayList<Contact> contactList, String contactText) throws IOException {
        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";
        for (Contact cnt : contactList) {
            satir += cnt.getPhoneNumber() + " ";
            satir += cnt.getFirstName() + " ";
            satir += cnt.getLastName() + " ";
            satir += cnt.getSocialSecurityNumber() + "\n";
            //Collections.sort(contactList);
            buffer.write(satir);
            satir = "";

        }
        buffer.close();

    }

    //@overload
    public static void textYazma(HashSet<Contact> contactHash, String contactText) throws IOException {
        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";
        for (Contact cnt : contactHash) {
            satir += cnt.getPhoneNumber() + " ";
            satir += cnt.getFirstName() + " ";
            satir += cnt.getLastName() + " ";
            satir += cnt.getSocialSecurityNumber() + "\n";
            Iterator<Contact> iter = contactHash.iterator();
            while (iter.hasNext()) {

                System.out.println(iter.next());
                buffer.write(satir);
                satir = "";

            }
        }
        buffer.close();

    }
    //@overload

    public static void textYazma(HashMap<String, Contact> contactMap, String contactText) throws IOException {
        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";
        for (String cnt : contactMap.keySet()) {
            buffer.write(String.format("%s%n", contactMap.get(cnt)));
        }

        buffer.close();

    }

//@overload
    public static void textYazma(TreeSet<Contact> contactTree, String contactText) throws IOException {

        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";

        for (Contact cnt : contactTree) {
            satir += cnt.getPhoneNumber() + " ";
            satir += cnt.getFirstName() + " ";
            satir += cnt.getLastName() + " ";
            satir += cnt.getSocialSecurityNumber() + "\n";
            Iterator iter = contactTree.iterator();
            while (iter.hasNext()) {
                buffer.write(satir);
                satir = "";

            }
            buffer.close();

        }

    }

    //@overload
    public static void textYazma(List<Contact> lastNameContactList, String contactText) throws IOException {
        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";
        for (Contact cnt : lastNameContactList) {
            satir += cnt.getPhoneNumber() + " ";
            satir += cnt.getFirstName() + " ";
            satir += cnt.getLastName() + " ";
            satir += cnt.getSocialSecurityNumber() + "\n";
            buffer.write(satir);
            satir = "";

        }
        buffer.close();

    }
    //@overload

    public static void textYazma(Set<Contact> lastNameContactTree, String contactText) throws IOException {
        FileWriter writer = new FileWriter(contactText);
        BufferedWriter buffer = new BufferedWriter(writer);
        String satir = "";
        for (Contact cnt : lastNameContactTree) {
            satir += cnt.getPhoneNumber() + " ";
            satir += cnt.getFirstName() + " ";
            satir += cnt.getLastName() + " ";
            satir += cnt.getSocialSecurityNumber() + "\n";
            buffer.write(satir);
            satir = "";

        }
        buffer.close();

    }

}
