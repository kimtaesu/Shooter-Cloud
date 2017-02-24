import { ShooterWebFrontPage } from './app.po';

describe('shooter-web-front App', function() {
  let page: ShooterWebFrontPage;

  beforeEach(() => {
    page = new ShooterWebFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
