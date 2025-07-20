//package com.salah.gestiondestock.Web.Api;
//
//import com.salah.gestiondestock.Dtos.ClientDto;
//import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;
//
//public interface ClientApi {
//
////    @PostMapping(value = APP_ROOT + "/client/add", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
////    ClientDto addClient(@RequestBody ClientDto clientDto);
////
////    @PutMapping(value = APP_ROOT + "/client/updateClient", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
////    ClientDto updateClient(@RequestBody ClientDto clientDto);
////
////    @GetMapping(value = APP_ROOT + "/client/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
////    ClientDto getClientById(@PathVariable("idClient") Integer id)throws EntityNotFoundException;
////
////    @GetMapping(value = APP_ROOT + "/client/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
////    ClientDto getClientByEmail(@PathVariable("email") String email) throws EntityNotFoundException ;
////
////    @GetMapping(value = APP_ROOT + "/client/AllClient",produces = MediaType.APPLICATION_JSON_VALUE)
////    List<ClientDto> getAllClients();
////
////    @DeleteMapping(value = APP_ROOT + "/client/delete/{idClient}")
////    void deleteClientById(@PathVariable("idClient") Integer id);
//
//}
