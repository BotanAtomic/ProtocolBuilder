package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameContextRemoveMultipleElementsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 252;
    private boolean _isInitialized = false;
    private Vector<Number> elementsIds;
    private FuncTree _elementsIdstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 252;
    }

    public GameContextRemoveMultipleElementsMessage initGameContextRemoveMultipleElementsMessage(Vector<Number> param1) {
         this.elementsIds = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.elementsIds = new Vector.<Number>();
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
         this.serializeAs_GameContextRemoveMultipleElementsMessage(param1);
    }

    public void serializeAs_GameContextRemoveMultipleElementsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.elementsIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.elementsIds.length)
         {
            if(this.elementsIds[_loc2_] < -9.007199254740992E15 || this.elementsIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.elementsIds[_loc2_] + ") on element 1 (starting at 1) of elementsIds.");
            }
            param1.writeDouble(this.elementsIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextRemoveMultipleElementsMessage(param1);
    }

    public void deserializeAs_GameContextRemoveMultipleElementsMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of elementsIds.");
            }
            this.elementsIds.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextRemoveMultipleElementsMessage(param1);
    }

    public void deserializeAsyncAs_GameContextRemoveMultipleElementsMessage(FuncTree param1) {
         this._elementsIdstree = param1.addChild(this._elementsIdstreeFunc);
    }

    private void _elementsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._elementsIdstree.addChild(this._elementsIdsFunc);
            _loc3_++;
         }
    }

    private void _elementsIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of elementsIds.");
         }
         this.elementsIds.push(_loc2_);
    }

}