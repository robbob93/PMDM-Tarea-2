package linares.rodriguez.listadopersonajes;

public class PjData {

    private final String image;
    private final String name;
    private final String description;
    private final String skill;

    public PjData(String image, String name, String description, String skill) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skill = skill;
    }
    public PjData( String name, String description) {
        this.image = "image";
        this.name = name;
        this.description = description;
        this.skill = "habilidad";

    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSkill() {
        return skill;
    }





}
