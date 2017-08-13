package package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameDataPaddockObjectAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5990;
    private boolean _isInitialized = false;
    private PaddockItem paddockItemDescription = ;
    private FuncTree _paddockItemDescriptiontree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5990;
    }

    public GameDataPaddockObjectAddMessage initGameDataPaddockObjectAddMessage(PaddockItem param1) {
         this.paddockItemDescription = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.paddockItemDescription = new PaddockItem();
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
         this.serializeAs_GameDataPaddockObjectAddMessage(param1);
    }

    public void serializeAs_GameDataPaddockObjectAddMessage(ICustomDataOutput param1) {
         this.paddockItemDescription.serializeAs_PaddockItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameDataPaddockObjectAddMessage(param1);
    }

    public void deserializeAs_GameDataPaddockObjectAddMessage(ICustomDataInput param1) {
         this.paddockItemDescription = new PaddockItem();
         this.paddockItemDescription.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameDataPaddockObjectAddMessage(param1);
    }

    public void deserializeAsyncAs_GameDataPaddockObjectAddMessage(FuncTree param1) {
         this._paddockItemDescriptiontree = param1.addChild(this._paddockItemDescriptiontreeFunc);
    }

    private void _paddockItemDescriptiontreeFunc(ICustomDataInput param1) {
         this.paddockItemDescription = new PaddockItem();
         this.paddockItemDescription.deserializeAsync(this._paddockItemDescriptiontree);
    }

}