package technology.tabula.invoice.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            Pattern q = Pattern.compile("[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}");
            String[] lines = line.split(";");

            int dateIndis = -1;
            for(int i=0;i<lines.length;i++) {
                Matcher n = q.matcher(lines[i]);
                if (n.find()) {
                    dateIndis = i;
                    //System.out.println(i + ">"+tmp);
                    //System.out.println(i + ">"+tmp.split(";")[i]);
                    break;
                }
            }

            if (dateIndis != -1) {
                //System.out.println(line);
                //System.out.println("> " + dateIndis);
                success = sectionWork(lines, dateIndis);
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

    private Boolean sectionWork(String[] lines, int dateIndis) {
        //5->3891;26V1AA0;11728287**;SEVTAP;ÇİÇEK;      31/12/2019;48,28;1,33;9,39;37,56;2;0,00;18.0;4B;Ç;
        //6->3887;26V0YPH;45299052**;METE  ;LÜTFİ;BIYIK;31/12/2019;66,00;1,82;12,84;51,34;3;0,00;7.0;4A;Ç;19QDLRT;

        int fark = dateIndis - 5;

        SiraNo = lines[0];
        ReceteNo = lines[1];

        TCKimlikNo = lines[2];
        Adi = lines[3];
        if (fark>0) {
            Adi += Adi + " " + lines[4];
        }

        Soyadi = lines[4+fark];

        Recete = lines[5+fark];
        Toplam = lines[6+fark];
        Iskonto = lines[7+fark];
        KatTut = lines[8+fark];
        OdenenTut = lines[9+fark];

        Adet = lines[10+fark];
        MuaMaas =  lines[11+fark];
        MuaElden =  lines[12+fark];
        Kapsam = (13+fark) < lines.length ? lines[13+fark] : null;
        SigortaliTur = (14+fark) < lines.length ? lines[14+fark] : null;
        EreceteNo = (15+fark) < lines.length ? lines[15+fark] : null;

        Maj = (16+fark) < lines.length ? lines[16] : null;
        Barkodlu = (17+fark) < lines.length ? lines[17] : null;
        MRapor = (18+fark) < lines.length ? lines[18] : null;

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
