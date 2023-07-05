package com.shop.app.controller;
import com.shop.app.domain.ResponseResult;
import com.shop.app.domain.product.ProductDTO;
import com.shop.app.service.ProductService;
import com.shop.app.utils.TrimAndValid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService serviceInfoService;

//    @GetMapping("/{id}")
//    public ResponseResult<ServiceDetailResponse> getDetails(@PathVariable("id") Long id) {
//        return ResponseResult.ofSuccess(serviceInfoService.getDetails(id));
//    }

    @PostMapping()
    public ResponseResult<ProductDTO> create(@TrimAndValid @RequestBody ProductDTO productDTO) {
        return ResponseResult.ofSuccess(serviceInfoService.createProduct(productDTO));
    }
//
//    @RequestMapping(value = "/{id}")
//    public ResponseResult<ServiceInfoResponse> update(@PathVariable("id") Long id, @TrimAndValid @ModelAttribute UpdateServiceRequest updateServiceRequest) {
//        return ResponseResult.ofSuccess(serviceInfoService.update(id, updateServiceRequest));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseResult<String> delete(@PathVariable("id") Long id) {
//        serviceInfoService.safeDelete(id);
//        return ResponseResult.ofSuccess();
//    }
//
//    @PostMapping("/search")
//    public ResponseResult<Page<ServiceSearchResponse>> search(@TrimAndValid @RequestBody SearchServiceRequest searchServiceRequest, Pageable pageable) {
//        return ResponseResult.ofSuccess(serviceInfoService.search(searchServiceRequest, pageable));
//    }
//
//    @GetMapping("/getAll")
//    public ResponseResult<List<ServiceSearchResponse>> getAllServiceInfoActive() {
//        return ResponseResult.ofSuccess(serviceInfoService.getAllServiceInfoActive());
//    }
//
//    @PostMapping(value = "/download/contract-form")
//    public ResponseEntity<?> downloadMultipleContactFormFile(@RequestBody List<Long> ids) {
//        return ResponseEntity.ok(serviceInfoService.downloadMultipleContractFormFile(ids));
//    }
//
//    @PostMapping(value = "/download/contract-form/{id}")
//    public ResponseEntity downloadSingleFileContactForm(@PathVariable Long id, HttpServletResponse httpServletResponse) {
//        InfoDownloadResponse response = serviceInfoService.downloadSingleContractFormFile(id);
//        httpServletResponse.setContentType("application/x-download");
//        httpServletResponse.setHeader("Content-Disposition",
//                "attachment; filename=" + DataUtils.convertNameToCode(response.getFileName()));
//        return ResponseEntity.ok(response.getFile());
//    }
//
//    @PostMapping(value = "/download/attach/{id}")
//    public byte[] downloadAttachFile(@PathVariable Long id, HttpServletResponse httpServletResponse) {
//        InfoDownloadResponse response = serviceInfoService.downloadAttachFile(id);
//        httpServletResponse.setContentType("application/x-download");
//        httpServletResponse.setHeader("Content-Disposition",
//                "attachment; filename=" + DataUtils.convertNameToCode(response.getFileName()));
//        return response.getFile();
//    }
//
//    @PostMapping(value = "/download/contract/attach/{id}")
//    public ResponseEntity downloadAttachContractFile(@PathVariable Long id, HttpServletResponse httpServletResponse) {
//        InfoDownloadResponse response = serviceInfoService.downloadContractFile(id);
//        httpServletResponse.setContentType("application/x-download");
//        httpServletResponse.setHeader("Content-Disposition",
//                "attachment; filename=" + DataUtils.convertNameToCode(response.getFileName()));
//        return ResponseEntity.ok(response.getFile());
//    }
}
