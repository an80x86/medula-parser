package technology.tabula.invoice.dto;

public class Master {
    private String line;

    private String FaturaTarihi;
    private String SonlandirmaTarihi;
    private String FaturaNumarasi;
    private String EczaneSicili;
    private String Adi;
    private String DokumNumarasi;

    public Master(String line) {
        this.line = line;
    }

    public String getFaturaTarihi() {
        return FaturaTarihi;
    }

    public String getSonlandirmaTarihi() {
        return SonlandirmaTarihi;
    }

    public String getFaturaNumarasi() {
        return FaturaNumarasi;
    }

    public String getEczaneSicili() {
        return EczaneSicili;
    }

    public String getAdi() {
        return Adi;
    }

    public String getDokumNumarasi() {
        return DokumNumarasi;
    }
}
