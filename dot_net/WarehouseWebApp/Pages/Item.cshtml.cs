using Costco.Warehouse.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace MyApp.Namespace
{
    public class ItemModel : PageModel
    {
        public Item ItemData { get; set; }

        public string Id { get; set; }

        public void OnGet(string id)
        {
            Id = id;

            if (id != null)
            {
                ItemData = (Item)DataCache.Items[id];
            }
        }
    }
}
