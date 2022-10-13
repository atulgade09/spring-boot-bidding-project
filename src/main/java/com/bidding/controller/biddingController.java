package com.bidding.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bidding.model.AcceptedBids;
import com.bidding.model.Bidder;
import com.bidding.model.BiddingData;
import com.bidding.model.Owner;
import com.bidding.model.User;
import com.bidding.repository.UserRepo;
import com.bidding.service.BiddingService;

@Controller
public class biddingController {
	@Autowired
	BiddingService bidService;
	static User user;
	static BiddingData biddingData;
	int bidId = 0;
	int bidIdForEdit = 0;

	@RequestMapping("/")
	public String index() {
		return "newRegistration.jsp";
	}

	@RequestMapping("/index")
	public String index2() {
		return "newRegistration.jsp";
	}

	@RequestMapping("login")
	public String login() {
		return "newLoginPage.jsp";
	}

	@RequestMapping("owner")
	public String owner() {
		return "owner.jsp";
	}

	@PostMapping(path = "/register")
	public String saveUser(User user) {
		bidService.saveUser(user);
		return "registered.jsp";
	}

	@GetMapping("/loginData")
	public String login(String email, String password) {
		User user = bidService.getUserByEmail(email);
		this.user = user;
		if (user != null) {
			if (bidService.verifiedUser(user, email, password)) {
				if (user.getUserType().equals("owner"))
					return "redirect:/getBiddingList";
				else
					return "redirect:/bidderPage";

			} else
				return "incorrect.jsp";
		} else
			return "newRegistration.jsp";

	}

	@PostMapping("/createBid")
	// @PutMapping("/createBid")
	public String ownerForm(Owner ow) {
		bidService.createOwnerData(ow);
		return "redirect:/getBiddingList";
	}

//	@RequestMapping(value="/OwnerDataForm")
//	public String OwnerDataForm() {
//		return "OwnerDataForm.jsp";
//	}
	@RequestMapping("/getBiddingList")
	public String getList(Model model) {
//		System.out.println(bidService.getBiddingData());
		List<BiddingData> list = bidService.getBiddingData();
		try {
//			for (BiddingData li : list) {
//				if (!li.getEmail().equals(user.getEmail())) {
//					list.remove(li);
//				}
//			}
			list = list.stream().filter(e -> e.getEmail().equals(user.getEmail())).collect(Collectors.toList());
			System.out.println(list);
		} catch (Exception e2) {
			System.out.println("Exception Handeled");
			e2.printStackTrace();
		}

//		model.addObject("list", list);
		model.addAttribute("list", list);
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		System.out.println(list);
//		model.setViewName("owner.jsp");
//		return bidService.getBiddingData();
//		return "ownerDetails.jsp";
		return "ownerDetails2.jsp";
	}

//	
//	@RequestMapping(value = "/OwnerDataForm")
//	public String Form() {
//		return "form.jsp";
//	}
	@RequestMapping(value = "/OwnerDataForm")
	public String Form() {
		return "form2.jsp";
	}

	@RequestMapping("/ownerDetails")
	public String ownerDetails() {
		return "ownerDetails.jsp";
	}

//	@PostMapping("/hello")
//	public String test(@RequestBody Owner owner) {
//		System.out.println( owner.getDescription());
//		System.out.println( owner.getCloseDate());
//		System.out.println();
//		return "owner.jsp";
//	}
	@RequestMapping("/editOwnerBid/{id}")
	public String editOwnerBid(@PathVariable("id") int id, Model model) {
//		biddingData=bidService.getBiddingDataById(id);
		biddingData = bidService.deleteBiddingDataById(id);
		model.addAttribute("bidData", biddingData);
		return "redirect:/form2Edit.jsp";
	}

	@PostMapping("/editForm")
	@PutMapping("/editForm")
	// @PutMapping("/createBid")
	public String editOwnerForm(Owner ow) {
		biddingData.setCreatedDate(ow.getCreatedDate());
		biddingData.setCloseDate(ow.getCloseDate());
		biddingData.setDescription(ow.getDescription());
		biddingData.setBidCost(ow.getBidCost());
		bidService.editBiddingData(biddingData);
		return "redirect:/getBiddingList";
	}

	@RequestMapping("/deleteOwnerBid/{id}")
	public String deleteOwnerBid(@PathVariable("id") int id, Model model) {
		System.out.println(id);
		bidService.deleteBiddingDataById(id);
		return "redirect:/getBiddingList";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "newLoginPage.jsp";
	}

	@RequestMapping("/bidderPage")
	public String bidderPage(Model model) {
		List<BiddingData> list = bidService.getBiddingData();
		list = list.stream().filter(e -> !e.getEmail().equals(user.getEmail())).collect(Collectors.toList());
//		List<Bidder> list2= bidService.getBidderList().stream().filter(e->e.getEmail().equals(user.getEmail())).collect(Collectors.toList());
//		System.out.println(list.stream().filter(e->bidId!=e.getBidId()).collect(Collectors.toList()));
		Iterator<BiddingData> it=list.iterator();
		while(it.hasNext()) {
			BiddingData list2=it.next();
			try {
				for(Bidder bidder:list2.getBidder()) {
					if(bidder.getEmail().equals(user.getEmail())) {
						it.remove();
					}
				}
			} catch (Exception e2) {
System.out.println("Exception ");
}
			
		}
		Collections.sort(list, new Comparator<BiddingData>() {

			@Override
			public int compare(BiddingData o1, BiddingData o2) {

				return o2.getBidId() - o1.getBidId();
			}

		});
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("disableId", bidId);
		return "bidderPage.jsp";
	}

	@RequestMapping("/raiseBid/{id}")
	public String raiseBid(@PathVariable("id") int id) {
		System.out.println(id);
//		bidService.getBiddingDataById(id);
		bidId = id;
		return "redirect:/raiseBidPage";
	}

	@RequestMapping("/raiseBidPage")
	public String raiseBidPage(Model model) {
		System.out.println(bidService.getBiddingDataById(bidId));
		model.addAttribute("bidData", bidService.getBiddingDataById(bidId));
		return "raiseBid.jsp";
	}

	@RequestMapping("/insertRaisedBid")
//	@PutMapping("/insertRaisedBid")
	public String insertRaisedBid(Bidder bidder) {
		System.out.println("inside insert Raised Bid " + bidder);
		System.out.println("inside insert Raised Bid " + user);
		bidder.setEmail(user.getEmail());
		bidder.setBidId(bidId);
		bidder.setName(user.getName());
		bidder.setBidderId(bidService.BidderIdGenerator());
		System.out.println("Bidder Generated Id :" + bidService.BidderIdGenerator());
//		new Operation starts here
		BiddingData biddingData = bidService.getBiddingDataById(bidId);
		bidService.deleteBiddingDataById(bidId);
//		List<Bidder>bid=biddingData.getBidder();
//		if(biddingData.getBidder()==null) {
//			List<Bidder>bid=new List<Bidder>();
//		}
//		biddingData.setBidder(bid);
//		List<Bidder>bid =bidService.bidderListByBiddingId(bidId);
//		bid.add(bidder);
		List<Bidder> bid;
		if (biddingData.getBidder() == null) {
			bid = new ArrayList<>();
		} else
			bid = biddingData.getBidder();
		bid.add(bidder);
		biddingData.setBidder(bid);
		bidService.saveOwnerBid(biddingData);
//		ends here
//		bidService.insertBidderData(bidder);
		return "redirect:/bidderPage";
	}

//	@RequestMapping("/bidderPageInsert")
//	public String bidderPageInsert() {
//		return "bidderPageInsert.jsp";
//	}
	@RequestMapping("/myBids")
	public String myBids(Model model) {
//		List<Bidder> bidderList = bidService.getBidderList();
//		List<BiddingData>bidData=bidService.getBiddingData();
//		bidderList.stream().filter(e->e.getEmail().equals(user.getEmail())).collect(Collectors.toList());
		List<BiddingData> biddingDataList = bidService.getBiddingData();
		System.out.println("Step 1 :" + biddingDataList);
		List<BiddingData> FilteredBiddingDataList = new ArrayList<>();
		System.out.println("Step 2");
		System.out.println("Total List :" + biddingDataList);

//		biddingDataList.stream().filter(e->e.getBidder().stream().filter(s->s.getEmail().equals(user.getEmail())).collect(Collectors.toList())).collect(Collectors.toList());
		try {
			for (BiddingData biddingList : biddingDataList) {
//				FilteredBiddingDataList.addAll(biddingList.getBidder().stream().filter(e->e.getEmail().equals(user.getEmail())).collect(Collectors.toList()));
				try {
					for (Bidder bidderlistCollection : biddingList.getBidder()) {
						if (bidderlistCollection.getEmail().equals(user.getEmail())) {
							FilteredBiddingDataList.add(biddingList);
							System.out.println(biddingList);
						}
					}
				} catch (Exception e) {
					System.out.println("inside Try Catch");
					e.printStackTrace();

				}

				//
//				FilteredBiddingDataList.addAll(biddingList.getBidder().stream().filter(e->e.getEmail().equals(user.getEmail()))).collect(Collectors.toList());
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(FilteredBiddingDataList);
//		model.addAttribute("list", bidderList);
//		model.addAttribute("user", user);
//		return "myBids.jsp";

		model.addAttribute("list", FilteredBiddingDataList);
		model.addAttribute("user", user);
		return "myBids2.jsp";
	}

	@RequestMapping("editBidderBid/{bidId}")
	public String editBidderBid(@PathVariable("bidId") int bidId, Model model) {
//		BiddingData biddingData=bidService.getBiddingDataById(bidId);
//		List<Bidder>bidder=biddingData.getBidder();
//		Bidder bidderObject=null;
//		for(Bidder bidderObj:bidder) {
//			if(bidderObj.getEmail().equals(user.getEmail())) {
//				bidderObject=bidderObj;
//			}
//		}
		bidIdForEdit = bidId;
//		model.addAttribute("bidData", biddingData);
		return "redirect:/editBidderBid";
	}

	@RequestMapping("/editBidderBid")
	public String EditBiderData(Model model) {
		BiddingData biddingData = bidService.getBiddingDataById(bidIdForEdit);
		model.addAttribute("bidData", biddingData);
		return "editRaiseBid.jsp";
	}

	@RequestMapping("editRaisedBid")
	public String editRaisedBid(Bidder newBidder) {
		BiddingData biddingData = bidService.getBiddingDataById(bidIdForEdit);
		List<Bidder> bidder = biddingData.getBidder();
		Bidder bidderObject = null;
		for (Bidder bidderObj : bidder) {
			if (bidderObj.getEmail().equals(user.getEmail())) {
				bidderObject = bidderObj;
			}
		}
		bidder.remove(bidderObject);
		bidderObject.setBidAmount(newBidder.getBidAmount());
		bidderObject.setWorkRange(newBidder.getWorkRange());
		System.out.println(bidderObject);
		System.out.println(bidder);
		bidder.add(bidderObject);
		biddingData.setBidder(bidder);
		bidService.deleteBiddingDataById(bidIdForEdit);
		bidService.saveOwnerBid(biddingData);
		return "redirect:/myBids";
	}

	@RequestMapping("deleteBidderBid/{id}")
	public String deleteBidderBid(@PathVariable("id") int id) {
		BiddingData biddingData = bidService.getBiddingDataById(id);
		List<Bidder> bidder = biddingData.getBidder();
		Bidder bidderObject = null;
		for (Bidder bidderObj : bidder) {
			if (bidderObj.getEmail().equals(user.getEmail())) {
				bidderObject = bidderObj;
			}
		}
		bidder.remove(bidderObject);
		biddingData.setBidder(bidder);
		bidService.deleteBiddingDataById(id);
		bidService.saveOwnerBid(biddingData);
		return "redirect:/myBids";
	}

	@RequestMapping("/accept/{id}/{email}")
	public String acceptBid(@PathVariable("id") int id, @PathVariable("email") String email) {
		BiddingData biddingData = bidService.deleteBiddingDataById(id);
		AcceptedBids acceptBid = new AcceptedBids();
		acceptBid.setBidData(biddingData);
		bidService.acceptBid(acceptBid);
//		biddingData.setStatus("inactive");
//		bidService.deleteBiddingDataById(id);
//		bidService.saveOwnerBid(biddingData);
		return "redirect:/getBiddingList";
	}

	@RequestMapping("/reject/{id}/{email}")
	public String rejectBid(@PathVariable("id") int id, @PathVariable("email") String email) {
		BiddingData biddingData = bidService.deleteBiddingDataById(id);
		Bidder bidder = null;
		List<Bidder> list = biddingData.getBidder();
		for (Bidder bidderList : list) {
			if (bidderList.getEmail().equals(email)) {
				bidder = bidderList;
			}
		}
		list.remove(bidder);
		bidService.saveOwnerBid(biddingData);
		return "redirect:/getBiddingList";

	}
	
	@RequestMapping("/showAcceptedList")
	public String showAcceptedList(Model model) {
		List<AcceptedBids>list=bidService.acceptedList().stream().filter(e->e.getBidData().getEmail().equals(user.getEmail())).collect(Collectors.toList());
	System.out.println(list);
	LinkedList<BiddingData>finalList=new LinkedList<>();
	for(AcceptedBids acceptedBids:list) {
		finalList.add(acceptedBids.getBidData());
	}
	System.out.println(finalList);
	model.addAttribute("user", user);
		model.addAttribute("list", finalList);
		return "ownerAcceptedList.jsp";
	}
	
	@RequestMapping("/acceptedBidderBids")
	public String showAcceptedBidderList(Model model) {
		List<AcceptedBids>list =bidService.acceptedList();
		System.out.println("list :"+list);
		List<BiddingData> biddingData = new ArrayList<>();
		for(AcceptedBids acceptedList :list) {
			System.out.println("bidder email"+acceptedList.getBidData().getBidder().get(0).getEmail());
			System.out.println("useremail"+user.getEmail());

			if(acceptedList.getBidData().getBidder().get(0).getEmail().equals(user.getEmail())) {
				biddingData.add(acceptedList.getBidData());
			}
		}
		System.out.println("biddingData :"+biddingData);
//		System.out.println(list);
		model.addAttribute("user", user);
		model.addAttribute("list", biddingData);
		return "acceptedBidderBids.jsp";
	}
	
}
