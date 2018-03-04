export class Upload {

  constructor(httpService: HttpService) {
    this.httpService = httpService;
    this.name = '';
    this.price = '';
    this.description = '';
    this.picture = null;
  }


  upload() {
    console.log("working1");


    let item = new FormData();
    item.append('picture', this.picture[0]);
    item.append('name', this.name);
    item.append('price', this.price);
    item.append('description', this.description);
    console.log(item.name);

    this.httpService.request('/file', {
      method: 'get',
      body: item
    }).then(response => {
      $(this.uploadForm).form('reset');
      setTimeout(() => {
      }, 1000)
    }).catch(error => {
      console.log(error);

    });

  }

}
