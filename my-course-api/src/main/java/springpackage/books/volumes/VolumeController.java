package springpackage.books.volumes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springpackage.books.Books;

@RestController
public class VolumeController {
	
	@Autowired
	private VolumeServices volumeServices;
	
	@RequestMapping("/books/{bookId}/volume")
	public List<Volume> getAllVolume(@PathVariable String bookId) {
		return volumeServices.getAllVolumes(bookId);
	}
	@RequestMapping("/books/{bookId}/volume/{id}")
	public Volume searchVolume(@PathVariable String id, @PathVariable String bookId) {
		return volumeServices.searchVolume(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/books/{bookId}/volume")
	public String addVolume(@PathVariable String bookId, @RequestBody Volume volume) {
		volume.setBook(new Books(bookId, "", "", ""));
		volumeServices.addVolume(volume);
		return "Successfully Added!";
	}
	@RequestMapping(method=RequestMethod.PUT, value="books/{bookId}/Volume/{id}")
	public String updateVolume(@PathVariable String bookId, @RequestBody Volume volume) {
		volume.setBook(new Books(bookId, "", "", ""));
		volumeServices.updateVolume(volume);
		return "Updated!";
	}
	@RequestMapping(method=RequestMethod.DELETE, value="books/{bookId}/volume/{id}")
	public String deleteVolume(@PathVariable String id) {
		volumeServices.deleteVolume(id);
		return "Deleted!";
	}
}
