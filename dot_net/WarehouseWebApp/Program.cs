using YamlDotNet.Core;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

var summaries = new[]
{
    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
};

DataCache.InitData();
DataCache.PrintData();

app.MapGet("/items", (HttpRequest request) =>
{
    return DataCache.Items.Values;
})
.WithName("GetItems");

app.MapGet("/item/{id}", (string id) =>
{
    return DataCache.Items[id];
})
.WithName("GetItem");

app.MapGet("/member/{id}", (string id) =>
{
    return DataCache.Members[id];
})
.WithName("GetMember");

app.MapGet("/order/{id}", (string id) =>
{
    return DataCache.Orders[id];
})
.WithName("GetOrder");

app.Run();


