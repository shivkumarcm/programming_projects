using YamlDotNet.Core;
using Costco.Warehouse.Data;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();
builder.Services.AddRazorPages();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

DataCache.InitData();
DataCache.PrintData();

app.UseStaticFiles();
app.UseDefaultFiles();
app.MapRazorPages();

app.MapGet("/items", (HttpRequest request) =>
{
    return DataCache.Items.Values;
})
.WithName("GetItems");

app.MapGet("/item", (string id) =>
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


