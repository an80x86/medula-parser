package technology.tabula.invoice.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bottom {
    private String Tutar;
    private String IskontoTutar;
    private String KatPayi;
    private String KDV8;
    private String KDV18;
    private String MuayeneUcreti;
    private String MuayeneUcretiElden;
    private String OdenecekTutar;
    private String EczaneHizmetBedeli;
    private String EczaneHizmetBedeliKdvTutari;
    private String ToplamOdenecek;

    public void SectionWork(String line) {
        int i=0;
        Pattern p = Pattern.compile("\\d+,\\d+");
        String[] patterns = new String[]{"Tutar:","İskonto Tutar","%10-%20 Kat.Payı","%8 KDV:","%18 KDV","Muayene Ücreti","Muayene Ücreti Elden", "Ödenecek Tutar","Eczane Hizmet Bedeli", "Eczane Hizmet Bedeli Kdv Tutarı", "Toplam Ödenecek"};
        for(i=0;i<patterns.length;i++) {
            try {
                switch (i) {
                    case 0: {
                        if (getTutar() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setTutar(m.group(0));
                            }
                        }
                    }
                    break;
                    case 1: {
                        if (getIskontoTutar() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setIskontoTutar(m.group(0));
                            }
                        }
                    }
                    break;
                    case 2: {
                        if (getKatPayi() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setKatPayi(m.group(0));
                            }
                        }
                    }
                    break;
                    case 3: {
                        if (getKDV8() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setKDV8(m.group(0));
                            }
                        }
                    }
                    break;
                    case 4: {
                        if (getKDV18() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setKDV18(m.group(0));
                            }
                        }
                    }
                    break;
                    case 5: {
                        if (getMuayeneUcreti() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setMuayeneUcreti(m.group(0));
                            }
                        }
                    }
                    break;
                    case 6: {
                        if (getMuayeneUcretiElden() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setMuayeneUcretiElden(m.group(0));
                            }
                        }
                    }
                    break;
                    case 7: {
                        if (getOdenecekTutar() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setOdenecekTutar(m.group(0));
                            }
                        }
                    }
                    break;
                    case 8: {
                        if (getEczaneHizmetBedeli() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setEczaneHizmetBedeli(m.group(0));
                            }
                        }
                    }
                    break;
                    case 9: {
                        if (getEczaneHizmetBedeliKdvTutari() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setEczaneHizmetBedeliKdvTutari(m.group(0));
                            }
                        }
                    }
                    break;
                    case 10: {
                        if (getToplamOdenecek() == null && line.contains(patterns[i])) {
                            int start = line.indexOf(patterns[i]) + patterns[i].length();
                            Matcher m = p.matcher(line.substring(start));
                            if (m.find()) {
                                setToplamOdenecek(m.group(0));
                            }
                        }
                    }
                    break;
                }
            }
            catch(Exception ex) {
                System.out.println("Split error(Bottom-"+i+") : " + ex.getMessage() + " -> " + line);
            }
        }
    }

    public String getTutar() {
        return Tutar;
    }

    public void setTutar(String tutar) {
        Tutar = tutar;
    }

    public String getIskontoTutar() {
        return IskontoTutar;
    }

    public void setIskontoTutar(String iskontoTutar) {
        IskontoTutar = iskontoTutar;
    }

    public String getKatPayi() {
        return KatPayi;
    }

    public void setKatPayi(String katPayi) {
        KatPayi = katPayi;
    }

    public String getKDV8() {
        return KDV8;
    }

    public void setKDV8(String KDV8) {
        this.KDV8 = KDV8;
    }

    public String getKDV18() {
        return KDV18;
    }

    public void setKDV18(String KDV18) {
        this.KDV18 = KDV18;
    }

    public String getMuayeneUcreti() {
        return MuayeneUcreti;
    }

    public void setMuayeneUcreti(String muayeneUcreti) {
        MuayeneUcreti = muayeneUcreti;
    }

    public String getMuayeneUcretiElden() {
        return MuayeneUcretiElden;
    }

    public void setMuayeneUcretiElden(String muayeneUcretiElden) {
        MuayeneUcretiElden = muayeneUcretiElden;
    }

    public String getOdenecekTutar() {
        return OdenecekTutar;
    }

    public void setOdenecekTutar(String odenecekTutar) {
        OdenecekTutar = odenecekTutar;
    }

    public String getEczaneHizmetBedeli() {
        return EczaneHizmetBedeli;
    }

    public void setEczaneHizmetBedeli(String eczaneHizmetBedeli) {
        EczaneHizmetBedeli = eczaneHizmetBedeli;
    }

    public String getEczaneHizmetBedeliKdvTutari() {
        return EczaneHizmetBedeliKdvTutari;
    }

    public void setEczaneHizmetBedeliKdvTutari(String eczaneHizmetBedeliKdvTutari) {
        EczaneHizmetBedeliKdvTutari = eczaneHizmetBedeliKdvTutari;
    }

    public String getToplamOdenecek() {
        return ToplamOdenecek;
    }

    public void setToplamOdenecek(String toplamOdenecek) {
        ToplamOdenecek = toplamOdenecek;
    }

    @Override
    public String toString() {
        return "Bottom{" +
                "Tutar='" + Tutar + '\'' +
                ", IskontoTutar='" + IskontoTutar + '\'' +
                ", KatPayi='" + KatPayi + '\'' +
                ", KDV8='" + KDV8 + '\'' +
                ", KDV18='" + KDV18 + '\'' +
                ", MuayeneUcreti='" + MuayeneUcreti + '\'' +
                ", MuayeneUcretiElden='" + MuayeneUcretiElden + '\'' +
                ", OdenecekTutar='" + OdenecekTutar + '\'' +
                ", EczaneHizmetBedeli='" + EczaneHizmetBedeli + '\'' +
                ", EczaneHizmetBedeliKdvTutari='" + EczaneHizmetBedeliKdvTutari + '\'' +
                ", ToplamOdenecek='" + ToplamOdenecek + '\'' +
                '}';
    }
}
