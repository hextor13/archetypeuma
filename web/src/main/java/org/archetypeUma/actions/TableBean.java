package org.archetypeUma.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.Cell;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "tableBean")
public class TableBean implements Serializable {

    /**
     * 
     */
    private static final long     serialVersionUID = 1L;

    private final static Logger   logger           = Logger.getLogger(TableBean.class
                                                           .getName());

    private final static String[] colors;

    private final static String[] manufacturers;

    private String                theme;

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        manufacturers = new String[10];
        manufacturers[0] = "Mercedes";
        manufacturers[1] = "BMW";
        manufacturers[2] = "Volvo";
        manufacturers[3] = "Audi";
        manufacturers[4] = "Renault";
        manufacturers[5] = "Opel";
        manufacturers[6] = "Volkswagen";
        manufacturers[7] = "Chrysler";
        manufacturers[8] = "Ferrari";
        manufacturers[9] = "Ford";
    }

    private List<Car>             cars;

    private List<Car>             carsSmall;

    private List<Car>             carsLarge;

    private Date                  date             = new Date();

    private Car                   selectedCar;

    private Car[]                 selectedCars;

    private Cell                  selectedCell;

    private Cell[]                selectedCells;

    private LazyDataModel<Car>    lazyModel;

    private List<String>          columns;

    private List<Car[]>           dynamicCars;

    private String                columnName;

    private SelectItem[]          manufacturerOptions;

    private List<Car>             droppedCars;

    public TableBean() {
        cars = new ArrayList<Car>();
        carsSmall = new ArrayList<Car>();
        carsLarge = new ArrayList<Car>();
        droppedCars = new ArrayList<Car>();

        populateRandomCars(cars, 50);
        populateRandomCars(carsSmall, 9);
        populateRandomCars(carsLarge, 200);

        createDynamicColumns();
        populateDynamicCars();
        manufacturerOptions = createFilterOptions(manufacturers);

        lazyModel = new LazyDataModel<Car>() {
            private static final long serialVersionUID = 234234234234234L;

            /**
             * Dummy implementation of loading a certain segment of data. In a
             * real application, this method should load data from a datasource
             */
            @Override
            public List<Car> load(int first, int pageSize, String sortField,
                    boolean sortOrder, Map<String, String> filters) {
                logger.log(Level.INFO,
                        "Loading the lazy car data between {0} and {1}",
                        new Object[] { first, (first + pageSize) });

                // Sorting and Filtering information are not used for demo
                // purposes just random dummy data is returned
                List<Car> lazyCars = new ArrayList<Car>();
                populateLazyRandomCars(lazyCars, pageSize);
                this.setPageSize(pageSize);

                return lazyCars;
            }
        };

        /**
         * In a real application, this number should be resolved by a projection
         * query
         */
        lazyModel.setRowCount(1000);
    }

    public LazyDataModel<Car> getLazyModel() {
        return lazyModel;
    }

    public Car[] getSelectedCars() {
        return selectedCars;
    }

    public void setSelectedCars(Car[] selectedCars) {
        this.selectedCars = selectedCars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private void populateRandomCars(List<Car> list, int size) {
        for (int i = 0; i < size; i++)
            list.add(new Car(getRandomModel(), getRandomYear(),
                    getRandomManufacturer(), getRandomColor()));
    }

    private void populateLazyRandomCars(List<Car> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(new Car(getRandomModel(), getRandomYear(),
                    getRandomManufacturer(), getRandomColor()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsSmall() {
        return carsSmall;
    }

    public List<Car> getCarsLarge() {
        return carsLarge;
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomManufacturer() {
        return manufacturers[(int) (Math.random() * 10)];
    }

    private int getRandomSale() {
        return (int) (Math.random() * 100000);
    }

    private int getRandomProfit() {
        return (int) (Math.random() * 100);
    }

    private String getRandomModel() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public Cell getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(Cell selectedCell) {
        this.selectedCell = selectedCell;
    }

    public Cell[] getSelectedCells() {
        return selectedCells;
    }

    public void setSelectedCells(Cell[] selectedCells) {
        this.selectedCells = selectedCells;
    }

    public void displaySelectedCells(ActionEvent actionEvent) {
        System.out.println(selectedCell.getColumnId());
        Car car = (Car) selectedCell.getRowData();
        System.out.println(car.getModel());
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                        "Changes Saved"));
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected",
                ((Car) event.getObject()).getModel());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected",
                ((Car) event.getObject()).getModel());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String onRowSelectNavigate(SelectEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash()
                .put("selectedCar", event.getObject());

        return "carDetail?faces-redirect=true";
    }

    private void populateDynamicCars() {
        dynamicCars = new ArrayList<Car[]>();

        for (int i = 0; i < 9; i++) {
            Car[] cars = new Car[columns.size()];

            for (int j = 0; j < columns.size(); j++) {
                cars[j] = new Car(getRandomModel(), getRandomYear(),
                        columns.get(j), getRandomColor());
            }

            dynamicCars.add(cars);
        }
    }

    private void createDynamicColumns() {
        columns = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            columns.add(manufacturers[i]);
        }
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<Car[]> getDynamicCars() {
        return dynamicCars;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void addColumn() {
        columns.add(columnName);
        columnName = null;

        populateDynamicCars();
    }

    public void removeColumn() {
        String columnToRemove = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("columnToRemove");

        columns.remove(columnToRemove);

        populateDynamicCars();
    }

    public String[] getManufacturers() {
        return manufacturers;
    }

    public String[] getColors() {
        return colors;
    }

    public List<String> getAvailableManufacturers() {
        List<String> availableManufacturers = new ArrayList<String>();

        for (String manufacturer : manufacturers) {
            if (!columns.contains(manufacturer))
                availableManufacturers.add(manufacturer);
        }

        return availableManufacturers;
    }

    private SelectItem[] createFilterOptions(String[] data) {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for (int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }

    public SelectItem[] getManufacturerOptions() {
        return manufacturerOptions;
    }

    public void onCarDrop(DragDropEvent ddEvent) {
        Car car = ((Car) ddEvent.getData());

        droppedCars.add(car);
        carsSmall.remove(car);
    }

    public List<Car> getDroppedCars() {
        return droppedCars;
    }
}