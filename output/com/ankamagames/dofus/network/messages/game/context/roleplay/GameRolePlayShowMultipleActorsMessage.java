package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameRolePlayShowMultipleActorsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6712;
    private boolean _isInitialized = false;
    private Vector.<GameRolePlayActorInformations> informationsList = ;
    private FuncTree _informationsListtree = ;
    private int _loc2_ = 0;
    private GameRolePlayActorInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private GameRolePlayActorInformations _loc3_ = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6712;
    }

    public GameRolePlayShowMultipleActorsMessage initGameRolePlayShowMultipleActorsMessage(Vector.<GameRolePlayActorInformations> param1) {
         this.informationsList = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.informationsList = new Vector.<GameRolePlayActorInformations>();
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
         this.serializeAs_GameRolePlayShowMultipleActorsMessage(param1);
    }

    public void serializeAs_GameRolePlayShowMultipleActorsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.informationsList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.informationsList.length)
            param1.writeShort((this.informationsList[_loc2_] as GameRolePlayActorInformations).getTypeId());
            (this.informationsList[_loc2_] as GameRolePlayActorInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayShowMultipleActorsMessage(param1);
    }

    public void deserializeAs_GameRolePlayShowMultipleActorsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         GameRolePlayActorInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.informationsList.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayShowMultipleActorsMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayShowMultipleActorsMessage(FuncTree param1) {
         this._informationsListtree = param1.addChild(this._informationsListtreeFunc);
    }

    private void _informationsListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._informationsListtree.addChild(this._informationsListFunc);
            _loc3_++;
    }

    private void _informationsListFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameRolePlayActorInformations _loc3_ = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.informationsList.push(_loc3_);
    }

}