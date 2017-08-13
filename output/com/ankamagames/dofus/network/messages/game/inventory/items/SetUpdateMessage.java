package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class SetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5503;
    private boolean _isInitialized = false;
    private int setId = 0;
    private int[] setObjects;
    private ObjectEffect[] setEffects;
    private FuncTree _setObjectstree;
    private FuncTree _setEffectstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.setId < 0)
         {
            throw new Exception("Forbidden value (" + this.setId + ") on element setId.");
         }
         param1.writeVarShort(this.setId);
         param1.writeShort(this.setObjects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.setObjects.length)
         {
            if(this.setObjects[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.setObjects[_loc2_] + ") on element 2 (starting at 1) of setObjects.");
            }
            param1.writeVarShort(this.setObjects[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.setEffects.length);
         int _loc3_ = 0;
         while(_loc3_ < this.setEffects.length)
         {
            param1.writeShort((this.setEffects[_loc3_] as ObjectEffect).getTypeId());
            (this.setEffects[_loc3_] as ObjectEffect).serialize(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         ObjectEffect _loc8_ = null;
         this.setId = param1.readVarUhShort();
         if(this.setId < 0)
         {
            throw new Exception("Forbidden value (" + this.setId + ") on element of SetUpdateMessage.setId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of setObjects.");
            }
            this.setObjects.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readUnsignedShort();
            _loc8_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc7_);
            _loc8_.deserialize(param1);
            this.setEffects.push(_loc8_);
            _loc5_++;
         }
    }

}