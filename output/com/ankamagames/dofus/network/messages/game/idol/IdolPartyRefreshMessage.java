package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.PartyIdol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolPartyRefreshMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6583;
    private boolean _isInitialized = false;
    private PartyIdol partyIdol;
    private FuncTree _partyIdoltree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6583;
    }

    public IdolPartyRefreshMessage initIdolPartyRefreshMessage(PartyIdol param1) {
         this.partyIdol = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.partyIdol = new PartyIdol();
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
         this.serializeAs_IdolPartyRefreshMessage(param1);
    }

    public void serializeAs_IdolPartyRefreshMessage(ICustomDataOutput param1) {
         this.partyIdol.serializeAs_PartyIdol(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolPartyRefreshMessage(param1);
    }

    public void deserializeAs_IdolPartyRefreshMessage(ICustomDataInput param1) {
         this.partyIdol = new PartyIdol();
         this.partyIdol.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolPartyRefreshMessage(param1);
    }

    public void deserializeAsyncAs_IdolPartyRefreshMessage(FuncTree param1) {
         this._partyIdoltree = param1.addChild(this._partyIdoltreeFunc);
    }

    private void _partyIdoltreeFunc(ICustomDataInput param1) {
         this.partyIdol = new PartyIdol();
         this.partyIdol.deserializeAsync(this._partyIdoltree);
    }

}