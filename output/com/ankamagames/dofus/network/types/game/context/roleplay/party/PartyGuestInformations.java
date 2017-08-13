package package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyGuestInformations extends Object implements INetworkType {

    private int protocolId = 374;
    private Number guestId = 0;
    private Number hostId = 0;
    private String name = "";
    private EntityLook guestLook = ;
    private int breed = 0;
    private boolean sex = false;
    private PlayerStatus status = ;
    private Vector.<PartyCompanionBaseInformations> companions = ;
    private FuncTree _guestLooktree = ;
    private FuncTree _statustree = ;
    private FuncTree _companionstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = param1.readUnsignedShort();
    private int _loc4_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 374;
    }

    public PartyGuestInformations initPartyGuestInformations(Number param1,Number  param2,String  param3,EntityLook  param4,int  param5,boolean  param6,PlayerStatus  param7,Vector.<PartyCompanionBaseInformations>  param8) {
         this.guestId = param1;
         this.hostId = param2;
         this.name = param3;
         this.guestLook = param4;
         this.breed = param5;
         this.sex = param6;
         this.status = param7;
         this.companions = param8;
         return this;
    }

    public void reset() {
         this.guestId = 0;
         this.hostId = 0;
         this.name = "";
         this.guestLook = new EntityLook();
         this.sex = false;
         this.status = new PlayerStatus();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyGuestInformations(param1);
    }

    public void serializeAs_PartyGuestInformations(ICustomDataOutput param1) {
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.guestId + ") on element guestId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyGuestInformations(param1);
    }

    public void deserializeAs_PartyGuestInformations(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc5_ = null;
         this._guestIdFunc(param1);
         this._hostIdFunc(param1);
         this._nameFunc(param1);
         this.guestLook = new EntityLook();
         this.guestLook.deserialize(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
            _loc5_ = new PartyCompanionBaseInformations();
            _loc5_.deserialize(param1);
            this.companions.push(_loc5_);
            _loc4_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyGuestInformations(param1);
    }

    public void deserializeAsyncAs_PartyGuestInformations(FuncTree param1) {
         param1.addChild(this._guestIdFunc);
         param1.addChild(this._hostIdFunc);
         param1.addChild(this._nameFunc);
         this._guestLooktree = param1.addChild(this._guestLooktreeFunc);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
         this._companionstree = param1.addChild(this._companionstreeFunc);
    }

    private void _guestIdFunc(ICustomDataInput param1) {
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.guestId + ") on element of PartyGuestInformations.guestId.");
    }

    private void _hostIdFunc(ICustomDataInput param1) {
         this.hostId = param1.readVarUhLong();
         if(this.hostId < 0 || this.hostId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.hostId + ") on element of PartyGuestInformations.hostId.");
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _guestLooktreeFunc(ICustomDataInput param1) {
         this.guestLook = new EntityLook();
         this.guestLook.deserializeAsync(this._guestLooktree);
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

    private void _companionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._companionstree.addChild(this._companionsFunc);
            _loc3_++;
    }

    private void _companionsFunc(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc2_ = new PartyCompanionBaseInformations();
         _loc2_.deserialize(param1);
         this.companions.push(_loc2_);
    }

}