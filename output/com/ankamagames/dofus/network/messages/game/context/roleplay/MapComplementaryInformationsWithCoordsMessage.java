package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.dofus.network.types.game.interactive.MapObstacle;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsDataMessage implements INetworkMessage {

    private int protocolId = 6268;
    private boolean _isInitialized = false;
    private int worldX = 0;
    private int worldY = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6268;
    }

    public MapComplementaryInformationsWithCoordsMessage initMapComplementaryInformationsWithCoordsMessage(int param1,int  param2,Vector<HouseInformations>  param3,Vector<GameRolePlayActorInformations>  param4,Vector<InteractiveElement>  param5,Vector<StatedElement>  param6,Vector<MapObstacle>  param7,Vector<FightCommonInformations>  param8,boolean  param9,FightStartingPositions  param10,int  param11,int  param12) {
         super.initMapComplementaryInformationsDataMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.worldX = param11;
         this.worldY = param12;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.worldX = 0;
         this.worldY = 0;
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
         this.serializeAs_MapComplementaryInformationsWithCoordsMessage(param1);
    }

    public void serializeAs_MapComplementaryInformationsWithCoordsMessage(ICustomDataOutput param1) {
         super.serializeAs_MapComplementaryInformationsDataMessage(param1);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapComplementaryInformationsWithCoordsMessage(param1);
    }

    public void deserializeAs_MapComplementaryInformationsWithCoordsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapComplementaryInformationsWithCoordsMessage(param1);
    }

    public void deserializeAsyncAs_MapComplementaryInformationsWithCoordsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of MapComplementaryInformationsWithCoordsMessage.worldX.");
         }
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of MapComplementaryInformationsWithCoordsMessage.worldY.");
         }
    }

}