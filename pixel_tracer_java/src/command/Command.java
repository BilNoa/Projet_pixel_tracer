package command;

import java.util.ArrayList;

/**
 * Représente une commande saisie par l'utilisateur (équivalent de struct command).
 * Les tokens de la ligne stdin sont classés en mots, entiers ou flottants.
 */
public class Command {

    private ArrayList<String> strParams = new ArrayList<>();
    private ArrayList<Integer> intParams = new ArrayList<>();
    private ArrayList<Float> fltParams = new ArrayList<>();

    public ArrayList<String> getStrParams() { return strParams; }
    public ArrayList<Integer> getIntParams() { return intParams; }
    public ArrayList<Float> getFltParams() { return fltParams; }

    public void addStrParam(String p) { strParams.add(p); }
    public void addIntParam(int p) { intParams.add(p); }
    public void addFltParam(float p) { fltParams.add(p); }
}
