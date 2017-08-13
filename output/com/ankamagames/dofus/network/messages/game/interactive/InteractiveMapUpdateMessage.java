package package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class InteractiveMapUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5002;
    private boolean _isInitialized = false;
    private Vector.<InteractiveElement> interactiveElements = ;
    private FuncTree _interactiveElementstree = ;
    private int _loc2_ = 0;
    private InteractiveElement _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private InteractiveElement _loc3_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5002;
    }

    public InteractiveMapUpdateMessage initInteractiveMapUpdateMessage(Vector.<InteractiveElement> param1) {
         this.interactiveElements = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.interactiveElements = new Vector.<InteractiveElement>();
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
         this.serializeAs_InteractiveMapUpdateMessage(param1);
    }

    public void serializeAs_InteractiveMapUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.interactiveElements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.interactiveElements.length)
            param1.writeShort((this.interactiveElements[_loc2_] as InteractiveElement).getTypeId());
            (this.interactiveElements[_loc2_] as InteractiveElement).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveMapUpdateMessage(param1);
    }

    public void deserializeAs_InteractiveMapUpdateMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         InteractiveElement _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc4_);
            _loc5_.deserialize(param1);
            this.interactiveElements.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveMapUpdateMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveMapUpdateMessage(FuncTree param1) {
         this._interactiveElementstree = param1.addChild(this._interactiveElementstreeFunc);
    }

    private void _interactiveElementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._interactiveElementstree.addChild(this._interactiveElementsFunc);
            _loc3_++;
    }

    private void _interactiveElementsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         InteractiveElement _loc3_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc2_);
         _loc3_.deserialize(param1);
         this.interactiveElements.push(_loc3_);
    }

}