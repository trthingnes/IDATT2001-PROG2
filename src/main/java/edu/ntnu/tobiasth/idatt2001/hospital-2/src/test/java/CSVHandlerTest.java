import edu.ntnu.tobiasth.idatt2001.hospital.util.CSVHandler;
import edu.ntnu.tobiasth.idatt2001.hospital.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVHandlerTest {
    @Test
    @DisplayName("CSV file reads successfully")
    void testCSVFileReadsSuccessfully() throws Exception {
        List<Patient> patientList = CSVHandler.readCSV(getClass().getResource("patients.csv").toURI());

        assertEquals(81, patientList.size());
    }
}
