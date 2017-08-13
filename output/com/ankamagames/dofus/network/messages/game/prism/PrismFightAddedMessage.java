package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismFightersInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismFightAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6452;
    private boolean _isInitialized = false;
    private PrismFightersInformation fight;
    private FuncTree _fighttree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6452;
    }

    public PrismFightAddedMessage initPrismFightAddedMessage(PrismFightersInformation param1) {
         this.fight = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fight = new PrismFightersInformation();
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
         this.serializeAs_PrismFightAddedMessage(param1);
    }

    public void serializeAs_PrismFightAddedMessage(ICustomDataOutput param1) {
         this.fight.serializeAs_PrismFightersInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightAddedMessage(param1);
    }

    public void deserializeAs_PrismFightAddedMessage(ICustomDataInput param1) {
         this.fight = new PrismFightersInformation();
         this.fight.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismFightAddedMessage(param1);
    }

    public void deserializeAsyncAs_PrismFightAddedMessage(FuncTree param1) {
         this._fighttree = param1.addChild(this._fighttreeFunc);
    }

    private void _fighttreeFunc(ICustomDataInput param1) {
         this.fight = new PrismFightersInformation();
         this.fight.deserializeAsync(this._fighttree);
    }

}