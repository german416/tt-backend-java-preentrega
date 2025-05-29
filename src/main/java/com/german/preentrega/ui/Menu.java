package com.german.preentrega.ui;

import com.german.preentrega.exceptions.DuplicateIndexException;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    //#region ATRIBUTOS
    private final static Scanner scanner = new Scanner(System.in);
    private final ArrayList<Option> options;
    private final String title;
    private final String body;
    private String footer;
    private Option selectedOption;
    //#endregion

    //#region CONSTRUCTORES
    public Menu() {
        options = new ArrayList<Option>();
        selectedOption = null;
        title = "";
        body = "";
        footer = "";
    }

    public Menu(String title, String body, String footer) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        this.body = body;
        this.footer = footer;
    }

    public Menu(String title, String body) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        this.body = body;
        this.footer = "";
    }

    public Menu(String title) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        body = "";
        footer = "";
    }
    //#endregion

    //#region MÉTODOS PÚBLICOS
    /**
     * Agrega una nueva opción a la lista de opciones del menú.
     *
     * <p>Este método crea una nueva instancia de la clase {@link Option} con el mensaje
     * y el índice proporcionados, y la agrega a la lista de opciones. Si el índice
     * ya existe en la lista, se lanza una excepción {@link DuplicateIndexException}.</p>
     *
     * @param message El mensaje que describe la opción. No puede ser {@code null}.
     * @param index El índice único que identifica la opción. No puede ser {@code null}.
     * @throws DuplicateIndexException Si el índice ya existe en la lista de opciones.
     */
    public void addOption(String message, Character index, Action action) throws Exception {
        if(indexExist(index)) {
            throw new DuplicateIndexException();
        }
        Option newOption = new Option(message, index, action);
        options.add(newOption);
    }

    public void run() throws Exception {
        while(true) {
            print();
            chooseOption();
            selectedOption.run();
            selectedOption = null;
        }
    }

    public void quit() {
        System.exit(0);
    }
    //#endregion

    //#region MÉTODOS PRIVADOS
    /**
     * Verifica si un índice específico existe dentro de las opciones del menú.
     * <p>
     * Este método consulta la lista de índices de las opciones del menú y verifica si
     * el índice proporcionado está presente en la misma.
     * </p>
     *
     * @param index El carácter que representa el índice a verificar.
     * @return <code>true</code> si el índice existe en el menú, <code>false</code> en caso contrario.
     */
    private boolean indexExist(char index) {
        ArrayList<Character> indexList = getIndexList();
        return indexList.contains(index);
    }

    /**
     * Retorna una lista de caracteres que representan los identificadores asignados
     * a cada opción del menú.
     * <p>
     * Un identificador es un carácter alfanumérico asociado a una opción del menú,
     * que se utiliza para seleccionar la opción cuando esta es elegida.
     * </p>
     *
     * @return Un tipo de dato <code>ArrayList&lt;Character&gt;</code> que puede estar vacío o no.
     */
    private ArrayList<Character> getIndexList() {
        ArrayList<Character> indexList = new ArrayList<Character>();
        char index;

        for(int i = 0; i < options.size(); i++) {
            index = options.get(i).getIndex();
            indexList.add(index);
        }

        return indexList;
    }

    /**
     * Solicita la selección de una opción del menú, busca el objeto <code>option</code> asociado
     * a la selección y lo guarda en la propiedad <code>selectedOption</code>.
     */
    private void chooseOption() {
        Character input;
        do {
            input = scanner.next().toLowerCase().charAt(0);

            if(indexExist(input)) {
                selectedOption = getOptionByIndex(input);
                break;
            }
        } while(!indexExist(input) && selectedOption == null);
    }

    private Option getOptionByIndex(Character index) {
        Option result = null;

        for(Option option : options) {
            if(option.getIndex() == index) {
                result = option;
            }
        }

        return result;
    }

    /**
     * Imprime en la consola el contenido del menú: título, cuerpo, opciones y footer.
     */
    private void print() {
        System.out.println(title);
        System.out.println(body);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getLabel());
        }
        System.out.print(footer);
    }
    //#endregion
}
