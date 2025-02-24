import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;

import junit.framework.TestCase;

public class TestCalciController extends TestCase {

	private final String BASE_URL = "http://localhost:9090/IndusResrService/rest/calci";
	private RestTemplate restTemplate;

	protected void setUp() throws Exception {
		restTemplate = new RestTemplate();

	}

	protected void tearDown() throws Exception {
		restTemplate = null;
	}

	public void testAdd() {
		CalciInput input = new CalciInput();
		input.setParam1(5.0);
		input.setParam2(3.0);
		ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/add", input, CalciOutput.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(8.0, response.getBody().getResult()); // Expected result
	}

	public void testSubtract() {
		CalciInput input = new CalciInput();
		input.setParam1(4.0);
		input.setParam2(6.0);
		ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/subtract", input,
				CalciOutput.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(-2.0, response.getBody().getResult()); // Expected result
	}

	public void testMultiply() {
		CalciInput input = new CalciInput();
		input.setParam1(3.0);
		input.setParam2(4.0);
		ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/multiply", input,
				CalciOutput.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(12.0, response.getBody().getResult()); // Expected result
	}

	public void testDivide() {
		CalciInput input = new CalciInput();
		input.setParam1(20.0);
		input.setParam2(4.0);
		ResponseEntity<CalciOutput> response = restTemplate.postForEntity(BASE_URL + "/divide", input,
				CalciOutput.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(5.0, response.getBody().getResult()); // Expected result
	}

}
