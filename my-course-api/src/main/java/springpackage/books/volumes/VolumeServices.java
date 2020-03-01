package springpackage.books.volumes;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeServices {
	
	@Autowired
	private VolumeRepository volumeRepository;

	public List<Volume> getAllVolumes(String bookId) {
		List<Volume> volumes = new LinkedList<>();
		volumeRepository.findByBookId(bookId).forEach(volumes::add);
		return volumes;
	}

	public Volume searchVolume(String id) {
		return volumeRepository.findOne(id);
	}

	public void addVolume(Volume volume) {
		volumeRepository.save(volume);
	}

	public void updateVolume(Volume volume) {
		volumeRepository.save(volume);
	}

	public void deleteVolume(String id) {
		volumeRepository.delete(id);
	}
}
