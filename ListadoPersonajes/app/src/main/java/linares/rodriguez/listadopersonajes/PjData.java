package linares.rodriguez.listadopersonajes;

public class PjData {

    private final int image;
    private final String name;
    private final String description;
    private final String skill;

    public PjData(int image, String name, String description, String skill) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skill = skill;
    }


    public int getImage() {
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
