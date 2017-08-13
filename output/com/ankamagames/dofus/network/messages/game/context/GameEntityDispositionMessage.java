package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameEntityDispositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5693;
    private boolean _isInitialized = false;
    private IdentifiedEntityDispositionInformations disposition;
    private FuncTree _dispositiontree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5693;
    }

    public GameEntityDispositionMessage initGameEntityDispositionMessage(IdentifiedEntityDispositionInformations param1) {
         this.disposition = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.disposition = new IdentifiedEntityDispositionInformations();
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
         this.serializeAs_GameEntityDispositionMessage(param1);
    }

    public void serializeAs_GameEntityDispositionMessage(ICustomDataOutput param1) {
         this.disposition.serializeAs_IdentifiedEntityDispositionInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameEntityDispositionMessage(param1);
    }

    public void deserializeAs_GameEntityDispositionMessage(ICustomDataInput param1) {
         this.disposition = new IdentifiedEntityDispositionInformations();
         this.disposition.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameEntityDispositionMessage(param1);
    }

    public void deserializeAsyncAs_GameEntityDispositionMessage(FuncTree param1) {
         this._dispositiontree = param1.addChild(this._dispositiontreeFunc);
    }

    private void _dispositiontreeFunc(ICustomDataInput param1) {
         this.disposition = new IdentifiedEntityDispositionInformations();
         this.disposition.deserializeAsync(this._dispositiontree);
    }

}