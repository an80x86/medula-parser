package technology.tabula.invoice.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Top {
    private String FaturaTarihi;
    private String SonlandirmaTarihi;
    private String FaturaNumarasi;
    private String EczaneSicili;
    private String EczaneAdi;
    private String DokumNumarasi;

    public void SectionWork(String line) {
        try {
            Pattern p = Pattern.compile("\\d+");
            if (getFaturaTarihi() == null && line.contains("Fatura Tarihi:;")) {
                int start = line.indexOf("Fatura Tarihi:;") + "Fatura Tarihi:;".length();
                setFaturaTarihi(line.substring(start, start + 10));
            }

            if (getSonlandirmaTarihi() == null && line.contains("Sonlandırma Tarihi:;;")) {
                int start = line.indexOf("Sonlandırma Tarihi:;;") + "Sonlandırma Tarihi:;;".length();
                setSonlandirmaTarihi(line.substring(start, start + 10));
            }

            if (getFaturaNumarasi() == null && line.contains("Fatura Numarası:")) {
                int start = line.indexOf("Fatura Numarası:") + "Fatura Numarası:".length();
                Matcher m = p.matcher(line.substring(start));
                if (m.find()) {
                    setFaturaNumarasi(m.group(0));
                }
            }

            if (getEczaneSicili() == null && line.contains("Eczane Sicili/Adı:;")) {
                int start = line.indexOf("Eczane Sicili/Adı:;") + "Eczane Sicili/Adı:;".length();
                String tmp = line.substring(start);
                int indis = tmp.indexOf("/");
                setEczaneSicili(line.substring(start, start + indis - 1).trim());

                setEczaneAdi (tmp.substring(tmp.indexOf("/") + 1, tmp.indexOf("Döküm Numarası")).trim().replace(";", ""));
            }

            if (getDokumNumarasi() == null && line.contains("Döküm Numarası:")) {
                int start = line.indexOf("Döküm Numarası:") + "Döküm Numarası:".length();
                Matcher m = p.matcher(line.substring(start));
                if (m.find()) {
                    setDokumNumarasi(m.group(0));
                }
            }
        }
        catch(Exception ex) {
            System.out.println("Split error(Top) : " + ex.getMessage() + " -> " + line);
        }
    }

    public String getFaturaTarihi() {
        return FaturaTarihi;
    }

    public void setFaturaTarihi(String faturaTarihi) {
        FaturaTarihi = faturaTarihi;
    }

    public String getSonlandirmaTarihi() {
        return SonlandirmaTarihi;
    }

    public void setSonlandirmaTarihi(String sonlandirmaTarihi) {
        SonlandirmaTarihi = sonlandirmaTarihi;
    }

    public String getFaturaNumarasi() {
        return FaturaNumarasi;
    }

    public void setFaturaNumarasi(String faturaNumarasi) {
        FaturaNumarasi = faturaNumarasi;
    }

    public String getEczaneSicili() {
        return EczaneSicili;
    }

    public void setEczaneSicili(String eczaneSicili) {
        EczaneSicili = eczaneSicili;
    }

    public String getEczaneAdi() {
        return EczaneAdi;
    }

    public void setEczaneAdi(String eczaneAdi) {
        EczaneAdi = eczaneAdi;
    }

    public String getDokumNumarasi() {
        return DokumNumarasi;
    }

    public void setDokumNumarasi(String dokumNumarasi) {
        DokumNumarasi = dokumNumarasi;
    }

    @Override
    public String toString() {
        return "Top{" +
                "FaturaTarihi='" + FaturaTarihi + '\'' +
                ", SonlandirmaTarihi='" + SonlandirmaTarihi + '\'' +
                ", FaturaNumarasi='" + FaturaNumarasi + '\'' +
                ", EczaneSicili='" + EczaneSicili + '\'' +
                ", EczaneAdi='" + EczaneAdi + '\'' +
                ", DokumNumarasi='" + DokumNumarasi + '\'' +
                '}';
    }
}
