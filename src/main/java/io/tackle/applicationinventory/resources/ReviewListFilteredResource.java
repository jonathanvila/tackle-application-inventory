package io.tackle.applicationinventory.resources;

import io.tackle.applicationinventory.entities.Review;
import io.tackle.commons.resources.ListFilteredResource;
import org.jboss.resteasy.links.LinkResource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("review")
public class ReviewListFilteredResource implements ListFilteredResource<Review> {

    @Override
    public Class<Review> getPanacheEntityType() {
        return Review.class;
    }

    @GET
    @Path("")
    @Produces({"application/json"})
    @LinkResource(
            entityClassName = "io.tackle.applicationinventory.entities.Review",
            rel = "list"
    )
    public Response list(@QueryParam(QUERY_PARAM_SORT) @DefaultValue(DEFAULT_VALUE_SORT) List var1,
                         @QueryParam(QUERY_PARAM_PAGE) @DefaultValue(DEFAULT_VALUE_PAGE) int var2,
                         @QueryParam(QUERY_PARAM_SIZE) @DefaultValue(DEFAULT_VALUE_SIZE) int var3,
                         @Context UriInfo var4) throws Exception {
        return ListFilteredResource.super.list(var1, var2, var3, var4, false);
    }

    @Path("")
    @GET
    @Produces({"application/hal+json"})
    public Response listHal(@QueryParam(QUERY_PARAM_SORT) @DefaultValue(DEFAULT_VALUE_SORT) List var1,
                            @QueryParam(QUERY_PARAM_PAGE) @DefaultValue(DEFAULT_VALUE_PAGE) int var2,
                            @QueryParam(QUERY_PARAM_SIZE) @DefaultValue(DEFAULT_VALUE_SIZE) int var3,
                            @Context UriInfo var4) throws Exception {
        return ListFilteredResource.super.list(var1, var2, var3, var4, true);
    }
}
