package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyNewGuestMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6260;
    private boolean _isInitialized = false;
    private PartyGuestInformations guest = ;
    private FuncTree _guesttree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6260;
    }

    public PartyNewGuestMessage initPartyNewGuestMessage(int param1,PartyGuestInformations  param2) {
         super.initAbstractPartyEventMessage(param1);
         this.guest = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.guest = new PartyGuestInformations();
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
         this.serializeAs_PartyNewGuestMessage(param1);
    }

    public void serializeAs_PartyNewGuestMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         this.guest.serializeAs_PartyGuestInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyNewGuestMessage(param1);
    }

    public void deserializeAs_PartyNewGuestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guest = new PartyGuestInformations();
         this.guest.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyNewGuestMessage(param1);
    }

    public void deserializeAsyncAs_PartyNewGuestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guesttree = param1.addChild(this._guesttreeFunc);
    }

    private void _guesttreeFunc(ICustomDataInput param1) {
         this.guest = new PartyGuestInformations();
         this.guest.deserializeAsync(this._guesttree);
    }

}