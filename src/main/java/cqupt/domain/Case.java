package cqupt.domain;

public class Case {
    private Integer id;

    private String name;

    private String icon;

    private Integer caseclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();//this.name = (name == null ? null : name.trim());
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getCaseclass() {
        return caseclass;
    }

    public void setClass(Integer caseclass) {
        this.caseclass = caseclass;
    }
}