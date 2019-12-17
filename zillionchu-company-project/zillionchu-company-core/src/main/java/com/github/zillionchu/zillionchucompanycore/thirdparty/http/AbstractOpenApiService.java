//package com.github.zillionchu.zillionchucompanycore.thirdparty.http;
//
//import com.google.common.escape.Escaper;
//import com.google.common.net.UrlEscapers;
//import org.apache.http.HttpResponse;
//import org.apache.http.StatusLine;
//import org.apache.http.client.methods.*;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//
///**
// * @类名称 AbstractOpenApiService
// * @类描述
// * @作者 chuyuefeng@tansun.cn
// * @创建时间 2019/9/20 10:38
// * @版本 1.00
// */
//public abstract class AbstractOpenApiService {
//
//    private static final Escaper pathEscaper = UrlEscapers.urlPathSegmentEscaper();
//
//    private final String baseUrl;
//    protected final CloseableHttpClient client;
//    protected final Gson gson;
//
//    AbstractOpenApiService(CloseableHttpClient client, String baseUrl, Gson gson) {
//        this.client = client;
//        this.baseUrl = baseUrl;
//        this.gson = gson;
//    }
//
//
//    /**
//     * get
//     *
//     * @param path
//     * @return
//     * @throws IOException
//     */
//    protected CloseableHttpResponse get(String path) throws IOException {
//        HttpGet get = new HttpGet(String.format("%s/%s", baseUrl, path));
//        return execute(get);
//    }
//
//    /**
//     * post
//     *
//     * @param path
//     * @param entity
//     * @return
//     * @throws IOException
//     */
//    protected CloseableHttpResponse post(String path, Object entity) throws IOException {
//        HttpPost post = new HttpPost(String.format("%s/%s", baseUrl, path));
//        return execute(post, entity);
//    }
//
//    /**
//     * put
//     *
//     * @param path
//     * @param entity
//     * @return
//     * @throws IOException
//     */
//
//    protected CloseableHttpResponse put(String path, Object entity) throws IOException {
//        HttpPut put = new HttpPut(String.format("%s/%s", baseUrl, path));
//        return execute(put, entity);
//    }
//
//    /**
//     * delete
//     *
//     * @param path
//     * @return
//     * @throws IOException
//     */
//
//    protected CloseableHttpResponse delete(String path) throws IOException {
//        HttpDelete delete = new HttpDelete(String.format("%s/%s", baseUrl, path));
//        return execute(delete);
//    }
//
//    protected String escapePath(String path) {
//        return pathEscaper.escape(path);
//    }
//
//    private CloseableHttpResponse execute(HttpEntityEnclosingRequestBase requestBase, Object entity) throws
//            IOException {
//        requestBase.setEntity(new StringEntity(gson.toJson(entity), ContentType.APPLICATION_JSON));
//        return execute(requestBase);
//    }
//
//    private CloseableHttpResponse execute(HttpUriRequest request) throws IOException {
//        CloseableHttpResponse response = client.execute(request);
//        checkHttpResponseStatus(response);
//        return response;
//    }
//
//    private void checkHttpResponseStatus(HttpResponse response) {
//        if (response.getStatusLine().getStatusCode() == 200) {
//            return;
//        }
//
//        StatusLine status = response.getStatusLine();
//        String message = "";
//        try {
//            message = EntityUtils.toString(response.getEntity());
//        } catch (IOException e) {
//            //ignore
//        }
//
//        // throw new OpenApiException(status.getStatusCode(), status.getReasonPhrase(), message);
//    }
//
//
//}
