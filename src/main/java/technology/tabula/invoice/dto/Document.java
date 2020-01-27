package technology.tabula.invoice.dto;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String line;
    private Boolean success = false;

    // section-1
    private String SiraNo;
    private String ReceteNo;

    // section-2
    private String TCKimlikNo;
    private String Adi;

    // section-3
    private String Soyadi;
    private String Recete;
    private String Toplam;
    private String Iskonto;
    private String KatTut;
    private String OdenenTut;

    // section-4
    private String Adet;
    private String MuaMaas;
    private String MuaElden;

    // section-5
    private String Kapsam;
    private String SigortaliTur;
    private String EreceteNo;

    // section-6
    private String Maj;

    // section-7
    private String Barkodlu;

    // section-8
    private String MRapor;

    public Document(String line) {
        try {
            this.line = line;
            if (line == null || line.length() == 0) return;

            int i=0;
            i++;
            //String desen = "ABCDEFGHIJKLMNOPRSTUVYZĞÜŞİÖÇabcdefghijklmnoprstuvyzığüşçö*/1234567890,";
            //String tmp = "";
            //List<String> fields = new ArrayList<>();
            //for(char c:line.toCharArray()) {
            //    Boolean isFind = false;
            //    for(char d:desen.toCharArray()) {
            //        if (d == c) {
            //            tmp += c;
            //            isFind = true;
            //        }
            //    }
            //    System.out.println(tmp);
            //    tmp="";
            //}

            String[] lines = line.split(";");
            if (lines.length == 7) {
                success = sectionA1Work(lines);
                success = (getSiraNo() != null) && isNumeric(getSiraNo());
                if (!success) return;

                success = sectionA2Work(lines);
                success = sectionA3Work(lines);
                success = sectionA4Work(lines);
                success = sectionA5Work(lines);
                success = sectionA6Work(lines);
                success = sectionA7Work(lines);
                success = sectionA8Work(lines);
            }
            else
            if (lines.length == 14) {
                success = sectionBWork(lines);

                success = (getSiraNo() != null) && isNumeric(getSiraNo());
            } else {
                System.out.println(lines.length);
                success = false;
            }
        }
        catch(Exception ex) {
            System.out.println("Error* : " + ex.getMessage() + " -> " + line);
            success = false;
        }
    }

    public Boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private Boolean sectionBWork(String[] lines) {
        if (lines.length != 14) return false;

        SiraNo = lines[0];
        ReceteNo = lines[1];

        TCKimlikNo = lines[2];
        Adi = lines[3];

        Soyadi = lines[4];
        Recete = lines[5];
        Toplam = lines[6];
        Iskonto = lines[7];
        KatTut = lines[8];
        OdenenTut = lines[9];

        Adet = lines[10];
        try {
            MuaMaas = lines[11].split(" ")[0];
            MuaElden = lines[11].split(" ")[1];
        }
        catch(Exception ex) {
            System.out.println("Split error(MuaMaas) : " + ex.getMessage());
        }

        Kapsam = lines[12];

        try {
            SigortaliTur = lines[13].split(" ")[0];
            EreceteNo = lines[13].split(" ")[1];
        }
        catch(Exception ex) {
            System.out.println("Split error(SigortaliTur) : " + ex.getMessage());
        }

        //Kapsam = lines[14];
        //SigortaliTur = lines[15];
        //EreceteNo = lines[16];

        return true;
    }

    private Boolean sectionA1Work(String[] lines) {
        if (lines.length < 1) return false;
        String[] section = lines[0].split(" ");

        if (section.length < 2) return false;
        SiraNo = section[0];
        ReceteNo = section[1];

        return true;
    }

    private Boolean sectionA2Work(String[] lines) {
        if (lines.length < 2) return false;
        String[] section = lines[1].split(" ");

        if (section.length < 2) return false;
        TCKimlikNo = section[0];
        Adi = section[1];
        if (section.length >2)  {
            Adi += " " + section[2];
        }

        return true;
    }

    private Boolean sectionA3Work(String[] lines) {
        if (lines.length < 5) return false;
        String[] section = lines[4].split(" ");

        if (section.length < 3) return false;
        Soyadi = section[0];
        Recete = section[1];
        Toplam = section[2];
        Iskonto = section[3];
        KatTut = section[4];
        OdenenTut = section[5];

        return true;
    }

    private Boolean sectionA4Work(String[] lines) {
        if (lines.length < 6) return false;
        String[] section = lines[5].split(" ");

        if (section.length < 3) return false;
        Adet = section[0];
        MuaMaas = section[1];
        MuaElden = section[2];

        return true;
    }

    private Boolean sectionA5Work(String[] lines) {
        if (lines.length < 7) return false;
        String[] section = lines[6].split(" ");

        if (section.length < 3) return false;
        Kapsam = section[0];
        SigortaliTur = section[1];
        EreceteNo = section[2];

        return true;
    }

    private Boolean sectionA6Work(String[] lines) {
        if (lines.length < 8) return true;
        Maj = lines[7];

        return true;
    }

    private Boolean sectionA7Work(String[] lines) {
        //if (lines.length < 9) return false;
        if (lines.length < 9) return true;
        Barkodlu = lines[8];

        return true;
    }

    private Boolean sectionA8Work(String[] lines) {
        //if (lines.length < 10) return false;
        if (lines.length < 10) return true;
        MRapor = lines[9];

        return true;
    }

    public String getSiraNo() {
        return SiraNo;
    }

    public String getReceteNo() {
        return ReceteNo;
    }

    public String getTCKimlikNo() {
        return TCKimlikNo;
    }

    public String getAdi() {
        return Adi;
    }

    public String getSoyadi() {
        return Soyadi;
    }

    public String getRecete() {
        return Recete;
    }

    public String getToplam() {
        return Toplam;
    }

    public String getIskonto() {
        return Iskonto;
    }

    public String getKatTut() {
        return KatTut;
    }

    public String getOdenenTut() {
        return OdenenTut;
    }

    public String getAdet() {
        return Adet;
    }

    public String getMuaMaas() {
        return MuaMaas;
    }

    public String getMuaElden() {
        return MuaElden;
    }

    public String getKapsam() {
        return Kapsam;
    }

    public String getSigortaliTur() {
        return SigortaliTur;
    }

    public String getEreceteNo() {
        return EreceteNo;
    }

    public String getMaj() {
        return Maj;
    }

    public String getBarkodlu() {
        return Barkodlu;
    }

    public String getMRapor() {
        return MRapor;
    }

    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "Document{" +
                "SiraNo='" + SiraNo + '\'' +
                ", ReceteNo='" + ReceteNo + '\'' +
                ", TCKimlikNo='" + TCKimlikNo + '\'' +
                ", Adi='" + Adi + '\'' +
                ", Soyadi='" + Soyadi + '\'' +
                ", Recete='" + Recete + '\'' +
                ", Toplam='" + Toplam + '\'' +
                ", Iskonto='" + Iskonto + '\'' +
                ", KatTut='" + KatTut + '\'' +
                ", OdenenTut='" + OdenenTut + '\'' +
                ", Adet='" + Adet + '\'' +
                ", MuaMaas='" + MuaMaas + '\'' +
                ", MuaElden='" + MuaElden + '\'' +
                ", Kapsam='" + Kapsam + '\'' +
                ", SigortaliTur='" + SigortaliTur + '\'' +
                ", EreceteNo='" + EreceteNo + '\'' +
                ", Maj='" + Maj + '\'' +
                ", Barkodlu='" + Barkodlu + '\'' +
                ", MRapor='" + MRapor + '\'' +
                '}';
    }
}
