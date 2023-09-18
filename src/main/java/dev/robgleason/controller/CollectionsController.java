package dev.robgleason.controller;


import dev.robgleason.dto.CollectionEntityDto;
import dev.robgleason.services.CollectionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/collections")
@AllArgsConstructor
public class CollectionsController {

    private CollectionsService collectionsService;


    @PostMapping
    public ResponseEntity<CollectionEntityDto> createCollection(@RequestBody CollectionEntityDto collectionEntityDto) {
        CollectionEntityDto savedCollection = collectionsService.createCollection(collectionEntityDto);
        return new ResponseEntity<>(savedCollection, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CollectionEntityDto> getCollection(@PathVariable("id") Long collectionId) {
        CollectionEntityDto collectionByIdDto = collectionsService.getCollectionById(collectionId);
        return ResponseEntity.ok(collectionByIdDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CollectionEntityDto> updatedCollection(@PathVariable("id") Long collectionId, @RequestBody CollectionEntityDto collectionEntityDto) {
        collectionEntityDto.setId(collectionId);
        CollectionEntityDto updatedCollection = collectionsService.updateCollection(collectionEntityDto);
        return ResponseEntity.ok(updatedCollection);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCollection(@PathVariable("id") Long collectionId) {
        collectionsService.deleteCollection(collectionId);
        return ResponseEntity.ok("collection deleted successfully");
    }


}
