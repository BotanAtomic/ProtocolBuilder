package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightPlacementSwapPositionsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6544;
    private boolean _isInitialized = false;
    private Vector<IdentifiedEntityDispositionInformations> dispositions;
    private FuncTree _dispositionstree;
    private int _dispositionsindex = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6544;
    }

    public GameFightPlacementSwapPositionsMessage initGameFightPlacementSwapPositionsMessage(Vector<IdentifiedEntityDispositionInformations> param1) {
         this.dispositions = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dispositions = new Vector.<IdentifiedEntityDispositionInformations>(2,true);
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
         this.serializeAs_GameFightPlacementSwapPositionsMessage(param1);
    }

    public void serializeAs_GameFightPlacementSwapPositionsMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this.dispositions[_loc2_].serializeAs_IdentifiedEntityDispositionInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightPlacementSwapPositionsMessage(param1);
    }

    public void deserializeAs_GameFightPlacementSwapPositionsMessage(ICustomDataInput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this.dispositions[_loc2_] = new IdentifiedEntityDispositionInformations();
            this.dispositions[_loc2_].deserialize(param1);
            _loc2_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightPlacementSwapPositionsMessage(param1);
    }

    public void deserializeAsyncAs_GameFightPlacementSwapPositionsMessage(FuncTree param1) {
         this._dispositionstree = param1.addChild(this._dispositionstreeFunc);
    }

    private void _dispositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this._dispositionstree.addChild(this._dispositionsFunc);
            _loc2_++;
         }
    }

    private void _dispositionsFunc(ICustomDataInput param1) {
         this.dispositions[this._dispositionsindex] = new IdentifiedEntityDispositionInformations();
         this.dispositions[this._dispositionsindex].deserializeAsync(this._dispositionstree.children[this._dispositionsindex]);
         this._dispositionsindex++;
    }

}