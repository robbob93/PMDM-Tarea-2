package linares.rodriguez.listadopersonajes;


/**
 * Clase PjData que representa los datos de un personaje en la aplicación.
 * Incluye información sobre la imagen, el nombre, la descripción y la habilidad del personaje.
 */
public class PjData {

    private final int image;
    private final String name;
    private final String description;
    private final String skill;


    /**
     * Constructor de la clase PjData.
     *
     * @param image       ID del recurso de la imagen del personaje.
     * @param name        Nombre del personaje.
     * @param description Descripción del personaje.
     * @param skill       Habilidad especial del personaje.
     */
    public PjData(int image, String name, String description, String skill) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skill = skill;
    }

    /**
     * Obtiene el ID de recurso de la imagen del personaje.
     *
     * @return ID de recurso de la imagen.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del personaje.
     *
     * @return Descripción del personaje.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene la habilidad especial del personaje.
     *
     * @return Habilidad especial del personaje.
     */
    public String getSkill() {
        return skill;
    }





}
