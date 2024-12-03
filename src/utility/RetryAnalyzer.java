package utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	    // Define the retry counter and max retries
	    private int retryCount = 0;
	    private static final int MAX_RETRY_COUNT = 2;  // Maximum retry attempts

	    @Override
	    public boolean retry(ITestResult result) {
	        // If the retry count is less than the max, rerun the test
	        if (retryCount < MAX_RETRY_COUNT) {
	            retryCount++;
	            System.out.println("Retrying test " + result.getName() + " for the " + retryCount + " time.");
	            return true;  // Return true to indicate the test should be retried
	        }
	        return false; // Return false to stop retrying
	    }
	}


