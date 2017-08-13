package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyJoinMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5576;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private Number partyLeaderId = 0;
    private int maxParticipants = 0;
    private Vector.<PartyMemberInformations> members = ;
    private Vector.<PartyGuestInformations> guests = ;
    private boolean restricted = false;
    private String partyName = "";
    private FuncTree _memberstree = ;
    private FuncTree _gueststree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private PartyMemberInformations _loc7_ = null;
    private PartyGuestInformations _loc8_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private PartyMemberInformations _loc3_ = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc2_);
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5576;
    }

    public PartyJoinMessage initPartyJoinMessage(int param1,int  param2,Number  param3,int  param4,Vector.<PartyMemberInformations>  param5,Vector.<PartyGuestInformations>  param6,boolean  param7,String  param8) {
         super.initAbstractPartyMessage(param1);
         this.partyType = param2;
         this.partyLeaderId = param3;
         this.maxParticipants = param4;
         this.members = param5;
         this.guests = param6;
         this.restricted = param7;
         this.partyName = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.partyType = 0;
         this.partyLeaderId = 0;
         this.maxParticipants = 0;
         this.members = new Vector.<PartyMemberInformations>();
         this.guests = new Vector.<PartyGuestInformations>();
         this.restricted = false;
         this.partyName = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyJoinMessage(param1);
    }

    public void serializeAs_PartyJoinMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element partyLeaderId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyJoinMessage(param1);
    }

    public void deserializeAs_PartyJoinMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         PartyMemberInformations _loc7_ = null;
         PartyGuestInformations _loc8_ = null;
         super.deserialize(param1);
         this._partyTypeFunc(param1);
         this._partyLeaderIdFunc(param1);
         this._maxParticipantsFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc6_);
            _loc7_.deserialize(param1);
            this.members.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyJoinMessage(param1);
    }

    public void deserializeAsyncAs_PartyJoinMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._partyTypeFunc);
         param1.addChild(this._partyLeaderIdFunc);
         param1.addChild(this._maxParticipantsFunc);
         this._memberstree = param1.addChild(this._memberstreeFunc);
         this._gueststree = param1.addChild(this._gueststreeFunc);
         param1.addChild(this._restrictedFunc);
         param1.addChild(this._partyNameFunc);
    }

    private void _partyTypeFunc(ICustomDataInput param1) {
         this.partyType = param1.readByte();
         if(this.partyType < 0)
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyJoinMessage.partyType.");
    }

    private void _partyLeaderIdFunc(ICustomDataInput param1) {
         this.partyLeaderId = param1.readVarUhLong();
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element of PartyJoinMessage.partyLeaderId.");
    }

    private void _maxParticipantsFunc(ICustomDataInput param1) {
         this.maxParticipants = param1.readByte();
         if(this.maxParticipants < 0)
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element of PartyJoinMessage.maxParticipants.");
    }

    private void _memberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._memberstree.addChild(this._membersFunc);
            _loc3_++;
    }

    private void _membersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         PartyMemberInformations _loc3_ = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.members.push(_loc3_);
    }

    private void _gueststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._gueststree.addChild(this._guestsFunc);
            _loc3_++;
    }

    private void _guestsFunc(ICustomDataInput param1) {
         PartyGuestInformations _loc2_ = new PartyGuestInformations();
         _loc2_.deserialize(param1);
         this.guests.push(_loc2_);
    }

    private void _restrictedFunc(ICustomDataInput param1) {
         this.restricted = param1.readBoolean();
    }

    private void _partyNameFunc(ICustomDataInput param1) {
         this.partyName = param1.readUTF();
    }

}